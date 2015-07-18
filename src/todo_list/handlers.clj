(ns todo-list.handlers
   (:use
     [hiccup.core]
     [hiccup.page]))

(defn greet
  "A ring handler to process all requests sent to the webapp"
  [request]
   (html [:h1 "Hello, Clojure World"]
        [:p "Welcome to your first Clojure app, I now update automatically"]))

(defn goodbye
  "A song to wish you goodbye"
  [request]
  (html5 {:lang "en"}
           [:head (include-js "myscript.js") (include-css "mystyle.css")]
           [:body
            [:div [:h1 {:class "info"} "Walking back to happiness"]]
            [:div [:p "Walking back to happiness with you"]]
            [:div [:p "Said, Farewell to loneliness I knew"]]
            [:div [:p "Laid aside foolish pride"]]
            [:div [:p "Learnt the truth from tears I cried"]]]))

(defn about
  "Information about the website developer"
  [request]
  {:status 200
   :body "I am an awesome Clojure developer, well getting there..."
   :headers {}})

(defn request-info
  "View the information contained in the request, useful for debugging"
  [request]
  {:status 200
   :body (pr-str request)
   :headers {}})

(defn hello
  "A simple personalised greeting showing the use of variable parth elements"
  [request]
  (let [name (get-in request [:route-params :name])]
    {:status 200
     :body (str "Hello " name ".  I got your name from the web URL")
     :headers {}}))

(def operands {"+" + "-" - "*" * ":" /})

(defn calculator
  "A very simple calculator that can add, divide, subtract and multiply.  This is done through the magic of variable path elements."
  [request]
  (let [a  (Integer. (get-in request [:route-params :a]))
        b  (Integer. (get-in request [:route-params :b]))
        op (get-in request [:route-params :op])
        f  (get operands op)]
    (if f
      {:status 200
       :body (str (f a b))
       :headers {}}
      {:status 404
       :body "Sorry, unknown operator.  I only recognise + - * : (: is for division)"
       :headers {}})))

