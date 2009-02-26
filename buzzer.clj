(ns buzzer (:use fact))

(defn buzzword? [candidate buzzword]
  (= candidate buzzword))

(fact "buzzword?: true when string equals given buzzword" 
  [buzzword ["ajax" "dsl" "rest"]]
  (buzzword? buzzword buzzword))

(fact "buzzword?: false when string does not equal given buzzword" 
  [candidate ["apple" "cat" "house"]
   buzzword (repeat "ajax")]
  (false? (buzzword? candidate buzzword)))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'buzzer))
(.println *test-out*)