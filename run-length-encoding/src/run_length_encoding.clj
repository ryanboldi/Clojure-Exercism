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

(re-seq #"(\d+)?([a-zA-Z\s+])" "A33B") ; => (["A" nil "A"] ["33B" "33" "B"])

(defn get-count-vector [text]
  (map #(if (nil? (second %))
        (vector "1" (last %))
        (vector (second %) (last %))) (re-seq #"(\d+)?([a-zA-Z\s+])" text)))

(get-count-vector "33A33Bdef") ; => (["33" "A"] ["33" "B"] ["1" "d"] ["1" "e"] ["1" "f"])

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       get-count-vector
       (map #(apply str (repeat (read-string (first %)) (second %))))
       (apply str)))

