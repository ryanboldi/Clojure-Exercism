(ns run-length-encoding)

(defn encode [[fst & rst :as part]]
  (cond->> fst
    (seq rst) (str (count part))))

(defn run-length-encode
  "encodes a string with run-length-encoding"
  [plain-text]
  (->> plain-text
       (partition-by identity)
       (map encode)
       (apply str)))

;------ DECODE

(defn decode [[_ nbr ltr]]
  (cond->> ltr
    (not (nil? nbr)) (repeat (read-string nbr))
    (nil? nbr) identity
    :always (apply str)))

(defn run-length-decode
  "decodes a run-length-encoded string"
  [cipher-text]
  (->> cipher-text
       (re-seq #"(\d+)?([a-zA-Z\s+])")
       (map decode)
       (apply str)))

