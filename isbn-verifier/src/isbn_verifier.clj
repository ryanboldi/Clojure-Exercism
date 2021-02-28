(ns isbn-verifier
  (:require [clojure.string :as str]))

(defn sum-with-mults
  [number-list]
  (reduce +
          (map (fn [base mult] (* base mult))
               (map #(Character/digit % 10) number-list)
               (reverse (range 11)))))

(defn isbn? [isbn]
  (->> isbn
       (#(str/replace % #"-" ""))
       (butlast)
       (sum-with-mults)
       (+ (if (= \X (last isbn))
            10
            (Character/digit (last isbn) 10)))
       (#(mod % 11))
       zero?
       (and (re-matches #"^(\d{9}(\d|[X]))$" (str/replace isbn "-" "")))
       (#(or (= false %) (nil? %)))
       not))