(ns collatz-conjecture)


(defn doOneStep
  [num] (if (even? num)
          (/ num 2)
          (inc (* 3 num))))

(defn collatz
  ([num] (if (<= num 0)
           (throw (Exception. "needs to be non-zero positive"))
           (count (take-while (partial < 1) (iterate doOneStep num))))))