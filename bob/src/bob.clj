(ns bob)

(defn question? [s] (clojure.string/ends-with? s "?"))

(defn yelling? [s]
  (let [letters (filter #(Character/isLetter %) s)]
    (and (every? #(Character/isUpperCase %) letters) (seq letters))))

(defn get-response [s]
  (if (empty? s)
    "Fine. Be that way!"
    (if (question? s)
      (if (yelling? s)
        "Calm down, I know what I'm doing!"
        "Sure.")
      (if (yelling? s)
        "Whoa, chill out!"
        "Whatever."))))

(defn response-for [s]
  (get-response (clojure.string/trim-newline (clojure.string/trim s))))