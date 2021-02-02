(ns atbash-cipher)

(defn prep_for_cipher [s]
  "removes spaces and makes everything lowercase"
  (clojure.string/lower-case (clojure.string/replace (clojure.string/trim s) #"\s+" "")))

(defn encode [] ;; <- arglist goes here
  ;; your code goes here
  )