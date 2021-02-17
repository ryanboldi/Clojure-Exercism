(ns run-length-encoding)

(defn str->map
  "returns a list of maps to represent a string with a 1 for each letter's value"
  [text]
  (map #(zipmap [:letter :quantity] [% 1]) text))

(defn reduce-map [text-maps]
  (reduce (fn [maps next]
            (println maps next (last maps))
            (if (= (:letter (last maps)) (:letter next))
              (do (println "NICE") (conj maps (assoc (last maps) :letter (:letter (last maps)) :quantity (+ (:quantity (last maps)) (:quantity next)))))
              (conj maps next)))
          ()
          text-maps))

(reduce-map (str->map "RRRyan"))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text])

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text])

