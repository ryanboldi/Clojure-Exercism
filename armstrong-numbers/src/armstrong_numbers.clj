(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn get-int-vec [num]
  (map #(mod % 10) (take-while #(> % 0) (iterate #(quot % 10) num))))

(defn armstrong? [num]
  (loop [number (get-int-vec num) length (count number) index 0 sum 0]
    (if (>= index length)
      (= (bigint sum) num)
      (recur (butlast number) length (inc index) (+ sum (math/expt (last number) length))))))

