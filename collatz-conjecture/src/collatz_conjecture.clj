(ns collatz-conjecture)

(defn do-one-step [num]
  (if (even? num)
    (/ num 2)
    (inc (* 3 num))))

(defn collatz [num]
  (assert (pos? num))
  (->> (iterate do-one-step num)
       (take-while (partial < 1))
       (count)))