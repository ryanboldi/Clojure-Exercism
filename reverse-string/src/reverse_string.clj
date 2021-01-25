(ns reverse-string)

(defn reverse-string [s]
  ;loop through a split vector representing the string, keeping track of the reverse vector so far
  (loop [reversed [] left (clojure.string/split s #"") index 0]
    (if (>= index (clojure.core/count s))
      ;if we reach the end, return a conjoined string of the reversed vector
      (clojure.string/join "" reversed)
      ;if we arn't at the end, run the loop again with updated vectors and index
      (recur (into reversed (last left)) (into [] (drop-last left)) (inc index)))))