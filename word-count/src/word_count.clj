(ns word-count
  (:require [clojure.string]))

(defn count-words
  [[frst & rst :as part]]
  (hash-map frst (count part)))

(defn word-count [s] ;; <- arglist goes here
  ;; your code goes here
  (->> s
       (re-seq #"\w+")
       (map clojure.string/lower-case)
       (partition-by identity)
       (map count-words)
       (into {})))