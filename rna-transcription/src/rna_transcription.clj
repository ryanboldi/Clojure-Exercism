(ns rna-transcription)
(use `[clojure.string])

(def DNA->RNA {\G \C \C \G \T \A \A \U})

(defn to-rna [dna]
  (let [out (->> dna
                 (map DNA->RNA)
                 (join ""))]
    (if (->> (count out)
             (= (count dna))
             assert
             not)
      out)))