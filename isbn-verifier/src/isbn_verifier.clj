(ns isbn-verifier)

(defn sum-with-powers
  [number-list]
  (reduce +
          (map (fn [base pow] (reduce * (repeat pow base)))
               (map #(Character/digit % 10) number-list)
               (reverse (range 11)))))

(sum-with-powers '(1 2 3 4 5 6 7 8 9))

(defn isbn? [isbn]
  (->> isbn
       (remove #{\-})
       (count)
       ;(butlast)
       ;(sum-with-powers)
       ;(+ (if (= \X (last isbn))
      ;    10
      ;      (Character/digit (last isbn) 10)))
      ; (#(mod % 11))
       ))

(isbn? "3-598-31508-8")
(butlast "ryan")

