(ns foreman-api.api-maker
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

(defmacro defapi
  "Define a function for the api"
  [name desc http-method http-url-pattern & args]
  (let [call-http (get
                   {"GET" 'http/get
                    :GET 'http/get
                    "POST" 'http/post
                    :POST 'http/post
                    "PUT" 'http/put
                    :PUT 'http/put
                    "DELETE" 'http/delete
                    :DELETE 'http/delete}
                   http-method)]
    `(defn ~name
       ~desc
       [~@args & {fail# :fail :as params#}]
       (let [url# (format (str @*HOST* ~http-url-pattern) ~@args)
             formatted-params# (walk/postwalk
                                #(if (keyword? %)
                                   (-> % (name) (str/replace #"-" "_") (keyword))
                                   %) params#)
             output# @(~call-http
                       url#
                       (assoc @*CONNECTION* :query-params formatted-params#))]
         (when fail#
           (assert (< (:status output#) 400)
                   (str "Failed to call api (call-api " ~http-method " " url# " ...): "
                        (if (re-matches #"^application/json"
                                        (get-in output# [:headers :content-type]))
                          (get-in (json/read-str (:body output#))
                                  ["error" "message"])
                          output#))))
         (json/read-str (:body output#))))))
