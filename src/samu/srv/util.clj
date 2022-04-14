(ns samu.srv.util)

(defn oget [state key]
  (get state (symbol key)))