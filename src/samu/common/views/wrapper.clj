(ns samu.common.views.wrapper 
  (:require [hiccup.page :refer [html5]]))


(defn wrapper [content]
  (html5 [[:head
           [:meta {:charset "UTF-8"}]
           [:meta {:name "viewport", :content "width=device-width, initial-scale=1"}]
           [:link {:href "css/style.css", :rel "stylesheet", :type "text/css"}]
           [:link {:rel "icon", :href "https://clojurescript.org/images/cljs-logo-icon-32.png"}]]
          [:body
           [:div {:id "app"}
            content]
           [:script {:src "cljs-out/dev-main.js", :type "text/javascript"}]]]))