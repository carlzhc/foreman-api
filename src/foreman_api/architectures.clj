(ns foreman-api.architectures
  (:require [foreman-api.connection :refer :all]
            [org.httpkit.client :as http]
            [clojure.data.json :as json]))

(defn list-architectures
  "List all architectures"
  ([]
   (list-architectures {}))
  ([ params ]
   (json/read-str
    (:body @(http/get
             (str @*host* "/api/architectures")
             (assoc @*connection* :query-params params)))))
  ([operatingsystem-id params]
   (json/read-str
    (:body @(http/get
             (str @*host* "/api/operatingsystems/" operatingsystem-id "/architectures")
             (assoc @*connection* :query-params params))))))

(defn show-architecture
  "Show an architecture"
  ([architecture-id params]
   (json/read-str
    (:body @(http/get
             (str @*host* "/api/architectures/" architecture-id)
             (assoc @*connection* :query-params params)))))
  ([architecture-id]
   (show-architecture architecture-id {})))

(defn create-architecture
  "Create an architecture"
  ([architecture-name params]
   (json/read-str
    (:body @(http/post
             (str @*host* "/api/architectures")
             (assoc @*connection* :query-params
                     (assoc-in params [:architecture :name] architecture-name))))))
  ([architecture-name]
   (create-architecture architecture-name {})))

(defn update-architecture
  "Update an architecture"
  ([architecture-id params]
   (json/read-str
    (:body @(http/put
             (str @*host* "/api/architectures/" architecture-id)
             (assoc @*connection* :query-params
                    (assoc params :id architecture-id))))))
  ([architecture-id]
   (update-architecture architecture-id {})))

(defn delete-architecture
  "Delete an architecture"
  [architecture-id]
  (json/read-str
   (:body @(http/delete
            (str @*host* "/api/architectures/" architecture-id)
            (assoc @*connection* :query-params
                   {:id architecture-id})))))
