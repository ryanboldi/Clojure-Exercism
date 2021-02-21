(ns run-length-encoding)
(require 'clojure.string)
(alias 's 'clojure.string)

(defn str->map-list
  "returns a list of maps to represent a string with a 1 for each letter's value"
  [text]
  (map #(zipmap [:letter :quantity] [% 1]) text))

(defn reduce-map
  "reduces a list of maps with a letter and quantity, adding quantity of identical letters side by side"
  [text-maps]
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

(defn map->enc-string
  "converts a map with a letter and quantity to its respective encoded string"
  [let-quan-map]
  (str (:quantity let-quan-map) (:letter let-quan-map)))

(defn remove-ones
  "removes ones from a string if not followed by another number"
  [text]
  (loop [index 0 final-text ""]
    (if (or (empty? text) (= index (dec (count text))))
      (s/join "" (vector final-text (last text)))
      (if (= (nth text index) \1)
        (if (Character/isDigit (nth text (inc index)))
          (recur (inc index) (s/join "" (vector final-text (nth text index))))
          (recur (inc index) final-text))
        (recur (inc index) (s/join "" (vector final-text (nth text index))))))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       str->map-list
       reduce-map
       (#(map map->enc-string %))
       (apply str)
       remove-ones
       (apply str)))

;------ DECODE

(defn add-ones
  "adds ones in the string before decoding"
  [text]
  (loop [index -1 final-text ""]
    (if (= (dec (count text)) index)
      final-text
      (if (or (= index -1) (Character/isLetter (nth text index)) (= (nth text index) \space))
        (if (or (= (nth text (inc index)) \space) (Character/isLetter (nth text (inc index))))
          (recur (inc index) (s/join "" (vector final-text "1" (nth text (inc index)))))
          (recur (inc index) (s/join "" (vector final-text (nth text (inc index))))))
        (recur (inc index) (s/join "" (vector final-text (nth text (inc index)))))))))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (let [letters
        (->> cipher-text
             add-ones
             (#(s/split % #"\d+"))
             (remove #(= % "")))
        amounts
        (->> cipher-text
             add-ones
             (#(s/split % #"[a-zA-Z\s+]"))
             (remove s/blank?)
             (map read-string))]
    (apply str (map (fn [letter amount] (apply str (repeat amount letter))) letters amounts))))



(map (juxt count first) (partition-by identity "aaaabbbb"))