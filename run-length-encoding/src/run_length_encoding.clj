(ns run-length-encoding)
(require 'clojure.string)
(alias 's 'clojure.string)

(defn single?
  "given a vector of count and letter, return true if count is 1"
  [[count letter]]
  (= count 1))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
    (partition-by identity)
    (map (juxt count first))
    (map #(if (single? %)
             (str (second %))
             (apply str %)))
    (apply str)))

(run-length-encode "AAAAAAvvve")

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

