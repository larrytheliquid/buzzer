(ns buzzer (:use fact))

(defn buzzword? [candidate buzzword]
  true)

(fact "buzzword?: true when string equals given buzzword" []
  (buzzword? "ajax" "ajax"))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'buzzer))
(.println *test-out*)
;; buzzer:
;; - buzzword?: true when string equals given buzzword
;; 1 facts, 0 pending, 0 failed, 0 exceptions