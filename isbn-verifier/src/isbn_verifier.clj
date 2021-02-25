(ns isbn-verifier)

(defn isbn? [isbn] ;; <- arglist goes here
  ;; your code goes here
)

(defn get-int-list
  [number]
  (->> number
       (iterate #(quot % 10))
       (take-while #(> % 0))
       (map #(mod % 10))
       reverse))

(defn sum-with-powers
  [number-list]
  ())

(range 11)
(zipmap '(3 5 9 8 2 1 5 0 8 8) (reverse (range 10)))

