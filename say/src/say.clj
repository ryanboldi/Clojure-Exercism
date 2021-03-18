(ns say)

(defn number [num] ;; <- arglist goes here
  ;; your code goes here
  )

(def units {0 "zero"
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

(def names
  `(" "
    "thousand"
    "million"
    "billion"
    "trillion"))

(defn say-two-digit [inp]
  (let [num (map #(Character/digit % 10) (str inp))]
    (if (= 2 (count num))
      (if (= 1 (first num))
        (get one-tens (second num))
        (if (zero? (second num))
          (get tens (first num))
          (str (get tens (first num)) "-" (get units (second num)))))
      (get units (last num)))))

(defn say-three-digit [inp]
  (let [num (map #(Character/digit % 10) (str inp))]
    (if (= 3 (count num))
      (str (first num)
           " hundred "
           (say-two-digit
            (Integer/parseInt
             (str (second num) (last num))))))))

(defn break-up-num [inp]
  (let [stringified (reverse (str inp))] 
     (map #(Integer/parseInt 
            (apply str 
                   (reverse (apply list %)))) 
          (partition 3 3 [] stringified))))

(defn insert-names [inp]
  (let [broken (break-up-num inp)]
    (reverse (interleave names broken))))

(insert-names 314159265358979)