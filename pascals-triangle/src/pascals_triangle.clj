(ns pascals-triangle)

(def triangle)

(defn getRow [previous] "gets the next row given the previous one"
  (loop [currentRow [1]]
    (if (>= (clojure.core/count currentRow) (clojure.core/count previous))
      (conj currentRow 1)
      (recur (conj currentRow (+ (get previous (dec (clojure.core/count currentRow))) (get previous (clojure.core/count currentRow))))))))

(defn row
  "evaluates to pascal's triangle up to end_row"
  [end_row]
  (loop [rows [[1]] rowNm 1]
    (if (>= rowNm end_row)
      (peek rows)
      (recur (conj rows (getRow (peek rows))) (inc rowNm)))))


(row 55)