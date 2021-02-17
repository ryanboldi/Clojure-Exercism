(ns run-length-encoding)

(defn str->map
  "returns a list of maps to represent a string with a 1 for each letter's value"
  [text]
  (map #(zipmap [:letter :quantity] [% 1]) text))

(defn reduce-map [text-maps]
  (reverse
   (reduce
    (fn [maps next]
      (if (= (:letter (first maps)) (:letter next))
        (conj (rest maps)
              (assoc {}
                     :letter (:letter (first maps))
                     :quantity (+ (:quantity (first maps)) (:quantity next))))
        (conj maps next)))
    ()
    text-maps)))

(reduce-map (str->map "RRyAAnnAR"))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text])

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text])
