(ns samu.common.views.index 
  (:require #?(:cljs [oops.core :refer [oget]])
            [samu.cli.actions :refer [decrement increment set-text]]))

(defn page [state]
  [:div
   [:button {:onclick  #(increment state)} " +1 "]
   [:button {:onclick  #(decrement state)} " -1 "]
   [:input {:placeholder "type something",
            :onchange #(set-text state %)
            :value (oget state "text")}]
   [:pre (str state)]])
