(ns samu.common.views.index
  (:require #?(:cljs
               [oops.core :refer [oget]])
            #?(:cljs
               [samu.cli.actions :refer [decrement increment set-text]])
            #?@(:clj
                [[samu.srv.actions :refer [decrement increment set-text]]
                 [samu.srv.util :refer [oget]]])))

(defn page [state]
  [:div
   [:button {:onclick  #(increment state)} " +1 "]
   [:button {:onclick  #(decrement state)} " -1 "]
   [:input {:placeholder "type something",
            :onchange #(set-text state %)
            :value (oget state "text")}]
   [:pre (str state)]])
