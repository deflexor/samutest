(ns samu.srv.actions)

(defn increment [_state]
  (str "increment(state)"))

(defn decrement [state]
  (str "decrement(state)"))

(defn set-text [state event]
  (str "set-text(state, event)"))