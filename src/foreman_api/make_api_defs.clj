(ns foreman-api.make-api-defs
  (:require [foreman-api.connection :refer :all]
            [clojure.string :as str]
            [clojure.pprint :refer [pprint]]
            [clojure.walk :as walk]
            [clojure.zip :as zip]
            [org.httpkit.client :as http]
            [environ.core :refer [env]]
            [clojure.data.json :as json]
            [hickory.core :refer [parse as-hickory as-hiccup]]
            [hickory.zip :refer [hickory-zip hiccup-zip]]
            [hickory.select :as s]))

(defn -main
  "Extrive entries of api"
  []
  (let [response @(http/get (str @*HOST* "/apidoc") @*CONNECTION*)]
    (when (= 200 (:status response))
      (let [zhtml ((comp hickory-zip as-hickory parse :body) response)
            find-api (find-in-text #"^(GET|POST|PUT|DELETE)\s")]
        (loop [loc (next-pred zhtml find-api)
               apis []]
          (if-not (zip/end? loc)
            (recur (next-pred loc find-api)
                   (conj apis (conj (str/split
                                     (-> loc zip/node :content first)
                                     #"\s+")
                                    (-> loc
                                        zip/up
                                        zip/right
                                        zip/right
                                        zip/node
                                        :content
                                        first))))
            apis))))))
