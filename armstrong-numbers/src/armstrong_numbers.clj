(ns armstrong-numbers
  (:require [clojure.math.numeric-tower :as math]))

(defn get-int-vec [num]
  (map #(mod % 10) (take-while #(> % 0) (iterate #(quot % 10) num))))

(defn armstrong? [num]
  (= num (reduce + (map #(math/expt % (count (str num))) (get-int-vec num)))))