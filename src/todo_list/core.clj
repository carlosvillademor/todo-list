(ns todo-list.core
  (:require [todo-list.handlers :refer :all]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]
            [ring.handler.dump :refer [handle-dump]])
  (:gen-class))

(defroutes app
  (GET "/" [] greet)
  (GET "/goodbye" [] goodbye)
  (GET "/about" [] about)
  (GET "/handle-dump" [] handle-dump)
  (GET "/request-info" [] request-info)
  (GET "/hello/:name" [] hello)
  (GET "/calculator/:a/:op/:b" [] calculator)
  (compojure.route/resources "/");;load in static resources, eg CSS from resources/public
  (not-found "Sorry, page not found"))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (jetty/run-jetty app
    {:port (Integer. port-number)}))

(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (jetty/run-jetty (wrap-reload #'app)
     {:port (Integer. port-number)}))
