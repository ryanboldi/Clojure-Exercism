(ns beer-song)

(defn verse
  "Returns the nth verse of the song."
  ([num] (str num " bottles of beer on the wall, " num " bottles of beer. \nTake it down and pass it around, " (- num 1) " bottles of beer on the wall.\n"))
  ([] (str "No more bottles of beer on the wall, no more bottles of beer. \nGo to the store and buy some more, 99 bottles of beer on the wall.\n")))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (loop [num start]
             (if (> num 0)
               (do (println (verse num)) (recur (- num 1)))
               (println (verse)))))
  ([start end] (println (str start end))))

(sing 100)