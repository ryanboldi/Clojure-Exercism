(ns anagram)

(defn anagram?
  [template prospect]
  (and
   (= (sort template) (sort prospect))
   (not= template prospect)))

(defn anagrams-for [word prospect-list]
  (filter
   #(anagram? (clojure.string/lower-case word)
              (clojure.string/lower-case %)) prospect-list))