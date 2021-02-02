(ns bob)

(defn question? [s] (clojure.string/ends-with? s "?"))

(defn yelling? [s]
  (let [letters (filter #(Character/isLetter %) s)]
    (and (every? #(Character/isUpperCase %) letters) (seq letters))))

(defn get-response [s]
  (cond
    (empty? s) "Fine. Be that way!"
    (and (question? s) (yelling? s)) "Calm down, I know what I'm doing!"
    (question? s) "Sure."
    (yelling? s) "Whoa, chill out!"
    :else "Whatever."))

(defn response-for [s]
  (get-response (clojure.string/trim-newline (clojure.string/trim s))))