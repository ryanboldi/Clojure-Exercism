(ns rna-transcription)
(use `[clojure.string])

(def DNA->RNA {\G \C \C \G \T \A \A \U})

(defn to-rna [dna]
  (let [out (->> dna
                 (map DNA->RNA)
                 (join ""))]
    (assert (= (count dna) (count out)))
    out))

(to-rna "ACGT")