(ns buzzer)

(defn buzzword? [candidate buzzword]
  (.contains candidate buzzword))

(defn find-buzzwords [candidate buzzwords]
  (filter #(buzzword? candidate %) buzzwords))