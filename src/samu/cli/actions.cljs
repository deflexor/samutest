(ns samu.cli.actions 
  (:require [oops.core :refer [oget oset!+]]))


(defn increment [state]
  (oset!+ state "number" (inc (oget state "number"))))

(defn decrement [state]
  (oset!+ state "number" (dec (oget state "number"))))

(defn set-text [state event]
  (oset!+ state "text" (oget event "target.value")))
