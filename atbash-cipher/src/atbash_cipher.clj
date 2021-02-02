(ns atbash-cipher)

(defn prep_for_cipher
  "removes spaces and makes everything lowercase"
  [s]
  (clojure.string/lower-case (clojure.string/replace (clojure.string/trim s) #"\s+" "")))

(defn get_ciph_letter
  "gets the corresponding letter"
  [c]
  (char (+ 96 97 (- 26 (int c)))))

(defn parse_and_cipher
  "parses chars before ciphering them"
  [c]
  (cond
    (Character/isLetter c) (get_ciph_letter c)
    (Character/isDigit c) c
    :else ""))

(defn split_into_sections
  "splits the string into sets of 5 letters"
  [s]
  (->>
   (partition 5 5 "" s)
   (map (partial clojure.string/join ""))
   (clojure.string/join " ")))

(defn encode [s] ;; <- arglist goes here
  ;; your code goes here
  (split_into_sections
   (clojure.string/join
    "" (map parse_and_cipher (seq (prep_for_cipher s))))))
