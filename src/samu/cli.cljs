(ns ^:figwheel-hooks samu.cli
  (:require [goog.dom :as gdom]
            [samu.cli.store :refer [store]]))

(set! *warn-on-infer* true)

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (store (.parse js/JSON js/appState)))

(defn get-app-element []
  (gdom/getElement "app"))



;; specify reload hook with ^:after-load metadata
(defn ^:after-load on-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
