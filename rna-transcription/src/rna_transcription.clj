(ns rna-transcription)
(use `[clojure.string])

(def DNA "GCTA")
(def RNA "CGAU")


(defn d-to-r [letter]
  (assert (index-of DNA letter))
  (->> letter
       (index-of DNA)
       (nth RNA)
       str))

(defn to-rna [dna]
  (->> dna
       (#(split % #""))
       (map d-to-r)
       (join "")))