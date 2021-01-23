(ns beer-song)

(defn verse
  "Returns the nth verse of the song."
  ([num] (if (num > 2)
           (str num " bottles of beer on the wall, " num " bottles of beer.\nTake one down and pass it around, " (- num 1) " bottles of beer on the wall.\n")
           (if (= num 2)
             (str "2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 more bottle of beer on the wall.\n")
             (if (= num 1)
               (str "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n")
               (str "No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"))))))


(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start end] (loop [num start theRest []]
                 (if (> num end)
                   (recur (- num 1) (into theRest [(verse num) "\n"]))
                   (reduce str (into theRest [(verse num)])))))
  ([start] (sing start 0)))

(sing 2 1)