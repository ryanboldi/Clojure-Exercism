(ns bob)
(use 'clojure.string)

(defn question? [s] (ends-with? s "?"))

(defn yelling? [s]
  ;for this to return true, there must be alphabetic characters, and they must all be uppercase
  ;  
  ;this checks if there ARE letters in the string in the first place
  (if (some #(Character/isLetter %) s)
    ;this checks that every character is either not a letter, or is both a letter AND capitalized
    (every? #(or (not (Character/isLetter %)) (and (Character/isLetter %) (Character/isUpperCase %))) s)
    false))

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
  (get-response (trim-newline (trim s))))