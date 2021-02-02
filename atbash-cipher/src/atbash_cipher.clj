(ns atbash-cipher)

(defn prep_for_cipher
  "removes spaces and makes everything lowercase"
  [s]
  (clojure.string/lower-case (clojure.string/replace (clojure.string/trim s) #"\s+" "")))

(defn get_ciph_letter
  "gets the corresponding letter"
  [c]
  (char (+ 96 97 (- 26 (int (.charAt c 0))))))

(defn split_into_sections
  "splits the string into sets of 4 letters"
  [s]
  (->>
   (partition 4 4 "" s)
   (map (partial clojure.string/join ""))
   (clojure.string/join " ")))

(defn encode [] ;; <- arglist goes here
  ;; your code goes here
  )

(split_into_sections "Ryanisthebest")
