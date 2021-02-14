(ns armstrong-numbers)

(defn get-int-vec [num]
  (->> num
       (iterate #(quot % 10))
       (take-while #(>  % 0))
       (map #(mod % 10))))

(defn pow
  [base exp]
  (apply * (repeat exp base)))

(defn armstrong? [num]
  (= num (apply + (map #(pow % (count (str num))) (get-int-vec num)))))
