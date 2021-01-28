(ns hamming)

(defn distance [strand1 strand2]
  (if (not= (count strand1) (count strand2))
    nil
    (loop [diffs 0 index 0]
      (if (>= index (count strand1))
        diffs
        (if (not= (nth strand1 index) (nth strand2 index))
          (recur (inc diffs) (inc index))
          (recur diffs (inc index)))))))