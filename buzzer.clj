(ns buzzer (:use fact))

(defn buzzword? [candidate buzzword]
  true)

(fact "buzzword?: true when string equals given buzzword" 
  [buzzword (vector "ajax" "dsl" "rest")]
  (buzzword? buzzword buzzword))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'buzzer))
(.println *test-out*)