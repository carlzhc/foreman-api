(defproject foreman-api "0.1.0-SNAPSHOT"
  :description "Clojure lib for foreman api 2"
  :url "http://github.com/carlzhc/foreman-api"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "0.2.6"]
                 [http-kit "2.3.0"]
                 [environ "1.1.0"]]
  :repl-options {:init-ns foreman-api.core})
