(ns isbn-verifier
  (:require [clojure.string :as str]))

(defn valid-isbn?
  [isbn]
  (boolean (re-matches #"^(\d{9}(\d|[X]))$" isbn)))

(defn convert-digit-or-x
  [chr]
  (if (= \X chr)
    10
    (Character/digit chr 10)))

(defn isbn? [isbn]
  (let [target (str/replace isbn "-" "")]
    (and
     (valid-isbn? target)
     (->> target
          (map convert-digit-or-x)
          (map * (range 10 -1 -1))
          (apply +)
          (#(mod % 11))
          zero?))))