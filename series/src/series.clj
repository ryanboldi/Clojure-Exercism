(ns series)

(defn slices [string length]
  (loop [index 0 result []]
    (if (or (and (> index 0) (= length 0)) (> index (- (clojure.core/count string) length)))
      result
      (recur (inc index) (into result (vector (subs string index (+ index length))))))))
