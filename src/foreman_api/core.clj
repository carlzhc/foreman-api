(ns foreman-api.core
  (:require [clojure.string :as str]
            [clojure.walk :as walk]
            [org.httpkit.client :as http]
            [environ.core :refer [env]]
            [clojure.data.json :as json]))

(def ^:dynamic *host*
  (atom
   (or (env :foreman-host) "https://localhost")))

(def ^:dynamic *connection*
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

(defn call-api
  "Call foreman api with given parameters
  Return a map of result"
  [method url & {fail :fail
                 :or {fail true}
                 :as params}]
  (let [msdc (get
              {"get" http/get
               "post" http/post
               "put" http/put
               "delete" http/delete
               :get http/get
               :post http/post
               :put http/put
               :delete http/put} method)]
    (assert msdc (str "Unknown method to call: " method))
    (let [formatted-params
          (walk/postwalk #(if (keyword? %)
                            (-> % (name) (str/replace #"-" "_") (keyword))
                            %) params)
          output @(msdc
                   (str @*host* url)
                   (assoc @*connection* :query-params formatted-params))]
      (when fail
        (assert (< (:status output) 400)
                (str "Failed to call api (call-api " method " " url " ...): "
                     (if (re-matches #"^application/json"
                                     (get-in output [:headers :content-type]))
                       (get-in (json/read-str (:body output))
                               ["error" "message"])
                       output))))
      (json/read-str
       (:body output)))))

(defn get-hosts-info
 "Given host names, fetch their informations"
  [& hosts]
  (let [results (get-in (call-api :get "/api/hosts") ["results"])]
    (if hosts
      (filter #((set hosts) (get % "name")) results)
      results)))
