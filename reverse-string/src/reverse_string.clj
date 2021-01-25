(ns reverse-string)

(defn reverse-string [s]
  (loop [reversed [] left (clojure.string/split s #"") index 0]
    (if (>= index (clojure.core/count s))
      (clojure.string/join "" reversed)
      (recur (into reversed (peek left)) (vector (drop-last left)) (inc index)))))

(reverse-string "ryan")

