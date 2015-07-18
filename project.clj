(defproject todo-list "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                  [ring "1.4.0-beta2"]
                  [compojure "1.3.4"]]
  :min-lein-version "2.0.0"
  :main todo-list.core
  :uberjar-name "todo-list.jar"
  :profiles {:uberjar {:omit-source true
                       :aot :all}
             :dev {:main todo-list.core/-dev-main}})
