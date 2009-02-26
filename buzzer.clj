(ns buzzer (:use fact))

(defn buzzword? [candidate buzzword]
  true)

(fact "buzzword?: true when string equals given buzzword" 
  [buzzword ["ajax" "dsl" "rest"]]
  (buzzword? buzzword buzzword))

(fact "buzzword?: false when string does not equal given buzzword" 
  [candidate ["apple" "cat" "house"]
   buzzword ["ajax" "ajax" "ajax"]]
  (false? (buzzword? candidate buzzword)))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'buzzer))
(.println *test-out*)
;; buzzer:
;; - buzzword?: false when string does not equal given buzzword
;;   FAILURE WHEN: candidate = "apple", buzzword = "ajax"
;; - buzzword?: true when string equals given buzzword
;; 2 facts, 0 pending, 1 failed, 0 exceptions