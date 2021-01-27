(ns reverse-string)

(defn reverse-string [s]
  ;loop through a split vector representing the string, keeping track of the reverse vector so far
  (loop [reversed "" left s index 0]
    (if (>= index (clojure.core/count s))
      ;if we reach the end, return a conjoined string of the reversed vector
      reversed
      ;if we arn't at the end, run the loop again with updated vectors and index
      (recur (str reversed (last left)) (clojure.string/join "" (drop-last left)) (inc index)))))

(reverse-string "ryan")