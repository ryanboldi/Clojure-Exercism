(ns collatz-conjecture)

(defn collatz
  ([num steps] (if (= num 1)
                 steps
                 (if (clojure.core/even? num)
                   (collatz (/ num 2) (inc steps))
                   (collatz (inc (* 3 num)) (inc steps)))))
  ([num] (collatz num 0)))