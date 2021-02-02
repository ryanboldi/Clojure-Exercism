(ns atbash-cipher)

(defn prep_for_cipher
  "removes spaces and makes everything lowercase"
  [s]
  (clojure.string/lower-case (clojure.string/replace (clojure.string/trim s) #"\s+" "")))

(defn get_ciph_letter
  "gets the corresponding letter"
  [c]
  (char (+ 96 97 (- 26 (int c)))))

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
    "" (map get_ciph_letter (seq (prep_for_cipher s))))))
