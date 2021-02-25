(ns isbn-verifier)

(defn sum-with-powers
  [number-list]
  (reduce +
          (map (fn [base pow] (reduce * (repeat pow base)))
               (map #(Character/digit % 10) number-list) 
               (reverse (range 11)))))

(defn isbn? [isbn]
  (->> isbn
       (remove #{\-})
       (butlast)
       (sum-with-powers)
       (+ (if (= \X (last isbn))
            10
            (last isbn)))
       #(mod % 11)
       (= 0)))

(isbn? "3-598-31508-8")
(butlast "ryan")

