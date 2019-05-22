(ns foreman-api.api
  (:require [foreman-api.connection :refer :all]
            [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.walk :as walk]
            [org.httpkit.client :as http]
            [environ.core :refer [env]]
            [clojure.data.json :as json]))

(def ^:dynamic *PRE-API-CALL*
  "Function to be called before calling API.
  Args: parameter-map & args"
  (atom (constantly true)))

(def ^:dynamic *POST-API-CALL*
  "Function to be called after calling API.
  Args: api-return parameter-map & args"
  (atom (constantly true)))

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
       {:pre [(@*PRE-API-CALL* params# ~@args)]
        :post [(@*POST-API-CALL* ~(symbol "%") params# ~@args)]}
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

(load "api_defs")
