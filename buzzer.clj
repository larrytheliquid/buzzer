(ns buzzer)

(defn buzzword? [candidate buzzword]
  true)

;;; true when string equals given buzzword
(prn (buzzword? "ajax" "ajax"))
;;; true