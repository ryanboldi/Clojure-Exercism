(ns say)

(defn number [num] ;; <- arglist goes here
  ;; your code goes here
  )

(def units {0 ""
            1 "one"
            2 "two"
            3 "three"
            4 "four"
            5 "five"
            6 "six"
            7 "seven"
            8 "eight"
            9 "nine"})

(def one-tens {0 "ten"
               1 "eleven"
               2 "twelve"
               3 "thirteen"
               4 "fourteen"
               5 "fifteen"
               6 "sixteen"
               7 "seventeen"
               8 "eighteen"
               9 "nineteen"})

(def tens {2 "twenty"
           3 "thirty"
           4 "fourty"
           5 "fifty"
           6 "sixty"
           7 "seventy"
           8 "eighty"
           9 "ninety"})

(defn say-two-digit [inp]
  (let [num (map #(Character/digit % 10) (str inp))]
    (if (= 1 (first num))
      (get one-tens (second num))
      (str (get tens (first num)) "-" (get units (second num))))))

(say-two-digit -1)