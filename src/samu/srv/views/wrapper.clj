(ns samu.srv.views.wrapper 
  (:require [hiccup.page :refer [html5]]
            [clojure.data.json :as json]))


(defn wrapper [content state]
  (html5 [[:head
           [:meta {:charset "UTF-8"}]
           [:meta {:name "viewport", :content "width=device-width, initial-scale=1"}]
           [:link {:href "css/style.css", :rel "stylesheet", :type "text/css"}]
           [:link {:rel "icon", :href "https://clojurescript.org/images/cljs-logo-icon-32.png"}]]
          [:body
           [:div {:id "app"}
            content]
           [:script {:type "text/javascript"}
            (str "let appState = JSON.parse('" (json/write-str state) "')")]
           [:script {:src "cljs-out/dev-main.js", :type "text/javascript"}]]]))