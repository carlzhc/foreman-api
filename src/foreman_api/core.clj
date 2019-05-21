(ns foreman-api.core
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [org.httpkit.client :as http]
            [environ.core :refer [env]]
            [clojure.data.json :as json]))

(def ^:dynamic *HOST*
  (atom
   (or (env :foreman-host) "https://localhost")))

(def ^:dynamic *CONNECTION*
  (atom
   {:headers {"content-type" "application/json; charset=utf-8"}
    :timeout  (if-let [v (env :foreman-timeout)]
                (Integer. v)
                3000)
    :keepalive (if-let [v (env :foreman-keepalive)]
                 (Integer. v)
                 3000)
    :insecure? (if-let [v (env :foreman-insecure)]
                 ({"true" true "false" false
                   "yes" true "no" false} v)
                 true)
    :basic-auth (when-let [v (env :foreman-auth)]
                  (take 2 (str/split v #":")))}))

(def RESOURCE-TYPES
  {:architectures "name"
   :audits "auditable_name"
   :auth-source-externals "name"
   :auth-source-internals "name"
   :auth-source-ldaps "name"
   :auth-sources "name"
;;   :autosign "name"
   :bookmarks "name"
   :common-parameters "name"
;;   :compute-attributes "name"
   :compute-profiles "name"
   :compute-resources "name"
   :config-groups "name"
   :config-reports "host_name"
   :config-templates "name"
   :dashboard "name"
   :domains "name"
   :environments "name"
;;   :external-usergroups "name"
;;   :fact-values "name"
   :filters "resource_type"
;;   :home "name"
;;   :host-classes "name"
;;   :hostgroup-classes "name"
   :hostgroups "name"
   :hosts "name"
   :http-proxies "name"
;;   :images "name"
;;   :interfaces "name"
   :locations "name"
   :mail-notifications "name"
   :media "name"
   :models "name"
;;   :operating-systems "name"
   :organizations "name"
;;   :os-default-templates "name"
;;   :override-values "name"
;;   :parameters "name"
   :permissions "name"
;;   :personal-access-tokens "name"
   :plugins "name"
   :provisioning-templates "name"
   :ptables "name"
;;   :puppet-hosts "name"
   :puppetclasses "name"
   :realms "name"
   :report-templates "name"
   :reports "host_name"
   :roles "name"
   :settings "name"
   :smart-class-parameters "name"
   :smart-proxies "name"
   :smart-variables "name"
;;   :ssh-keys "name"
   :statistics "name"
   :subnets "name"
;;   :table-preferences "name"
;;   :tasks "name"
;;   :template-combinations "name"
;;   :template-inputs "name"
   :template-kinds "name"
   :trends "name"
   :usergroups "name"
   :users "login"})


(def ^:dynamic *CACHE*
  "Cache the result of list-resources"
  (atom {}))

(defn clear-cache
  "Reset the CACHE to empty state"
  []
  (reset! *CACHE* {}))

(defn update-cache
  "Update the cache depending on the arguments"
  [resource content]
  (swap! *CACHE* assoc resource content))

(defn- keyword-hypen-to-underscore
  "Converts any hypen in keyword to underscore"
  [kw]
  (keyword (str/replace (name kw) #"-" "_")))

(defn call-api
  "Calls foreman api with given parameters,
  returns a map as result"
  [http-method url & {fail :fail
                      :or {fail true}
                      :as params}]
  (let [call-http (get
                   {"get" http/get
                    "post" http/post
                    "put" http/put
                    "delete" http/delete
                    :get http/get
                    :post http/post
                    :put http/put
                    :delete http/delete}
                   http-method)]
    (assert call-http (str "Unknown method to call: " http-method))
    (let [formatted-params ;; make hyphen like underscore
          (walk/postwalk #(if (keyword? %)
                            (-> % (name) (str/replace #"-" "_") (keyword))
                            %) params)
          output @(call-http
                   (str @*HOST* url)
                   (assoc @*CONNECTION* :query-params formatted-params))]
      (when fail
        (assert (< (:status output) 400)
                (str "Failed to call api (call-api " http-method " " url " ...): "
                     (if (re-matches #"^application/json"
                                     (get-in output [:headers :content-type]))
                       (get-in (json/read-str (:body output))
                               ["error" "message"])
                       output))))
      (json/read-str (:body output)))))

(defn list-resources
  "Fetches information for given resouce names"
  [resource & names]
  (assert #(RESOURCE-TYPES resource)
          (str "Unknown resource: " (name resource)))
  (let [results (get-in (call-api
                         :get
                         (str "/api/"
                              (name (keyword-hypen-to-underscore resource))))
                        ["results"])]
    (update-cache resource results)
    (if names
      (filter #((set names) (get % (get RESOURCE-TYPES resource))) results)
      results)))

(defn resources->ids
  "Map resources name to their ids"
  [resource-type & resource-names]
  (assert (get RESOURCE-TYPES resource-type)
          (str "Unknown resource type: " resource-type))
  (let [cached-resource (get @*CACHE* resource-type)
        resource (if cached-resource cached-resource
                     (list-resources resource-type))
        target-resource
        (if resource-names
          (let [nameset (set resource-names)
                nametag (get RESOURCE-TYPES resource-type)]
            (filter #(nameset (get % nametag)) resource))
          resource)]
    (map #(get % "id") target-resource)))

(defn create-resource
  "Create a resouce"
  [resource & params]
  (assert #(RESOURCE-TYPES resource)
          (str "Unknown resource: " (name resource)))
  (let [result #spy/d (apply call-api
                         :post
                         (str "/api/"
                              (name (keyword-hypen-to-underscore resource)))
                         params)]
    (when-not (get result "error") (list-resources resource))        ; update cache
    result))

(defn delete-resource
  "Delete a resource"
  [resource id & params]
  (assert #(RESOURCE-TYPES resource)
          (str "Unknown resource: " (name resource)))
  (let [result #spy/d (apply call-api
                             :delete
                             (str "/api/"
                                  (name (keyword-hypen-to-underscore resource))
                                  "/" id)
                             (concat params [:id id]))]
    (when-not (get result "error") (list-resources resource)) ; update cache
    result))

(defn update-resource
  "Update a resource"
  [resource id & params]
  (assert #(RESOURCE-TYPES resource)
          (str "Unknown resource: " (name resource)))
  (let [result #spy/d (apply call-api
                             :put
                             (str "/api/"
                                  (name (keyword-hypen-to-underscore resource))
                                  "/" id)
                             (concat params [:id id]))]
    (when-not (get result "error") (list-resources resource)) ; update cache
    result))

(defn list-hosts
  "Given host names, fetches their informations"
  [& names]
  (apply list-resources :hosts names))

(defn list-organizations
  "Given organization names, fetches their informations"
  [& names]
  (apply list-resources :organizations names))
