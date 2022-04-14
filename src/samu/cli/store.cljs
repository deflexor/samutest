(ns samu.cli.store
   (:require [oops.core :refer [oget oget+ oset! oset!+]]))

(def reactionsMap #js {})
(def curTmpl nil)

(def handler #js 
              {"get" (fn [target key]
                       (if (nil? curTmpl)
                         (oget+ target key)
                         (let [rmapValArr (oget+ reactionsMap key)]
                           (when (nil? rmapValArr)
                             (oset!+ reactionsMap key #js [curTmpl]))
                           (let [hasTmpl (.find rmapValArr (fn [e] (= e curTmpl)))]
                             (when-not hasTmpl
                               (.push rmapValArr curTmpl))))))
               "set" (fn [target key value]
                       (let [tval (or (oget+ target key) #js [])]
                         (.forEach tval (fn [t] (.forceUpdate t)))
                         tval))})

(defn store [obj]
  (.Proxy obj handler))

(defn view [f]
  (this-as this (fn [& args]
                  (oset! this "id" (str (.floor js/Math (* (.random js/Math) 100000))))
                  (set! curTmpl this)
                  (let [value (apply f args)]
                    (set! curTmpl nil)
                    value))))