(ns armstrong-numbers)

(defn get_int_vec [num] (into [] (map #(Character/digit % 10) (into [] (str num)))))

(defn armstrong? [num]
  (loop [number (get_int_vec num) length (count number) index 0  sum 0]
    (if (>= index length)
      (= (int sum) num)
      (recur (butlast number) length (inc index) (+ sum (Math/pow (last number) length))))))

(armstrong? 9)
