(ns foreman-api.make-api-defs
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [clojure.zip :as zip]
            [clojure.pprint :refer [pprint *print-right-margin*]]
            [foreman-api.connection :refer :all]
            [hickory.core :refer [as-hickory parse]]
            [hickory.select :refer [find-in-text next-pred]]
            [hickory.zip :refer [hickory-zip]]
            [org.httpkit.client :as http]
            [taoensso.timbre :as log])
  (:gen-class))

(defn- retrieve-api
  "Extrieve entries of api"
  []
  (let [response @(http/get (str @*HOST* "/apidoc") @*CONNECTION*)]
    (if (= 200 (:status response))
      (let [zhtml ((comp hickory-zip as-hickory parse :body) response)
            find-interface (find-in-text #"^(GET|POST|PUT|DELETE)\s")]
        (loop [loc (next-pred zhtml find-interface)
               interfaces []]
          (if (zip/end? loc) interfaces
              (recur (next-pred loc find-interface)
                     (conj interfaces
                           (conj (str/split
                                  (-> loc zip/node :content first)
                                  #"\s+")
                                 (-> loc
                                     zip/up
                                     zip/right
                                     zip/right
                                     zip/node
                                     :content
                                     first)))))))
      (do (log/error (str "failed to connect to host: "
                          (:error response)))))))

(defn- get-args
  "Fetch args from the url"
  [url]
  (->> url
       (re-seq #":\w+")
       (map #(str/replace % #":" ""))
       (map #(str/replace % #"_" "-"))
       (vec)))

(defn- format-args
  "Replace all args names with %s from the url
  and args names follows"
  [url]
  (cons (str/replace url #":\w+" "%s")
        (map #(-> %
                  (str/replace #":" "")
                  (str/replace \_ \-)
                  symbol)
             (re-seq #":\w+" url))))


(defn- generate-interface-name
  [desc]
  (-> desc
      (str/replace #",.*" "")
      (str/replace #" |/" "-")
      (str/lower-case)))

(defn- generate-desc
  [[method url desc]]
  (if desc desc
      (let [d1
            (case method
              "GET" "List all"
              "POST" "Create"
              "PUT" "Update"
              "DELETE" "Delete")
            reversed-url-parts
            (reverse (rest (re-seq #"[^/]+" url)))]
        (->> (if (= \: (first (first reversed-url-parts)))
               (concat ["a"
                        (str/replace (second reversed-url-parts) #"s$" "")]
                       (drop 2 reversed-url-parts))
               (cons "of" reversed-url-parts))
             (map #(if (= \: (first %)) "per" %))
             (str/join " ")
             (str d1 " ")))))

(defn- format-interface
  [[method url desc :as args]]
  (let [desc1 (generate-desc args)]
    (concat [(symbol (generate-interface-name desc1)) desc1 (keyword method)]
            (format-args url))))

(defn- make-a-def
  [interface]
  (cons 'defapi (format-interface interface)))

(defn- make-defs
  ([]
   (map make-a-def (retrieve-api)))
  ([interfaces]
   (map make-a-def interfaces)))

(defn -main
  ([]
   (binding [*print-right-margin* 0] ;every arg on its own line
     (doseq [def (make-defs)]
       (pprint def)
       (newline))))
  ([filename]
   (with-open [file (io/writer filename)]
     (binding [*out* file]
       (pprint '(in-ns 'foreman-api.api))
       (newline)
       (-main)))))
