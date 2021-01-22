(ns two-fer)

(defn two-fer
  "if no args are passed, we just call the function again with you as the arg"
  ([] (two-fer "you"))
  ([name] (str "One for " name ", one for me.")))
