(ns rna-transcription)

(def dna->rna {\G \C \C \G \T \A \A \U})

(defn to-rna [dna]
  (let [out (->> dna
                 (map dna->rna)
                 (apply str ""))]
    (assert (= (count dna) (count out)))
    out))