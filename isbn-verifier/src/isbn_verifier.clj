(ns isbn-verifier)

(defn sum-with-mults
  [number-list]
  (reduce +
          (map (fn [base mult] (* base mult))
               (map #(Character/digit % 10) number-list)
               (reverse (range 11)))))

(defn isbn? [isbn]
  (->> isbn
       (remove #{\-})
       (butlast)
       (remove #(re-matches #"[A-Za-z]" (str %)))
       (sum-with-mults)
       (+ (if (= \X (last isbn))
            10
            (Character/digit (last isbn) 10)))
       (#(mod % 11))
       (= 0)
       (and (re-matches #"\d|[X]" (str (last isbn))))
       (and (= 10 (count (remove #{\-} isbn))))
       boolean))