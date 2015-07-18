(ns todo-list.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn welcome
  "A ring handler to process all requests sent to the webapp"
  [request]
  {:status 200
   :body "<h1>Hi people, again</h1>  <p>Welcome to your first Clojure app.  This message is returned regardless of the request, sorry<p>"
   :headers {}})

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty welcome
    {:port (Integer. port-number)}))

(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'welcome)
     {:port (Integer. port-number)}))
