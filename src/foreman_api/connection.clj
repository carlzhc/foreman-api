(ns foreman-api.connection
  (:require [clojure.string :as str]
            [environ.core :refer [env]]))

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
