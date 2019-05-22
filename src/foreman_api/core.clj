(ns foreman-api.core
  (:require [foreman-api.connection :refer :all]
            [clojure.string :as str]
            [clojure.walk :as walk]
            [org.httpkit.client :as http]
            [environ.core :refer [env]]
            [clojure.data.json :as json]))

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
