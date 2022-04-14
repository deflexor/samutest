(ns samu.srv 
  (:require [compojure.core :refer [context defroutes GET POST]]
            [compojure.route :refer [files not-found]]
            [org.httpkit.server :refer [run-server]]
            [samu.common.views.index :as index]
            [samu.srv.views.wrapper :refer [wrapper]]))

(defn show-landing-page [req]
  (let [state { :number 0 :text "Hi" }]
    (wrapper (index/page state) state)))

(defn- update-userinfo [req]          ;; ordinary clojure function
  (let [user-id (-> req :params :id)    ; param from uri
        password (-> req :params :password)] ; form param
    "...."
    ))

(defn- get-user-by-id [req]
  (let [user-id (-> req :params :id)] ; form param
    (str "..." user-id "....")))

(defroutes all-routes
  (GET "/" [] show-landing-page)
  (context "/user/:id" []
           (GET / [] get-user-by-id)
           (POST / [] update-userinfo))
  (files "/static/" {:root "resources/public"})
  (files "/cljs-out/" {:root "target/public/cljs-out"})
  (not-found "<p>Page not found.</p>")) ;; all other, return 404


(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

(defn main [& args]
  ;; The #' is useful when you want to hot-reload code
  ;; You may want to take a look: https://github.com/clojure/tools.namespace
  ;; and https://http-kit.github.io/migration.html#reload
  (reset! server (run-server #'all-routes {:port 8080})))
