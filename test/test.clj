(ns test.buzzer (:use buzzer fact))

(def buzzwords ["ajax" "dsl" "rest"])
(def non-buzzwords ["apple" "cat" "house"])

(fact "buzzword?: true when string equals given buzzword" 
  [buzzword buzzwords]
  (buzzword? buzzword buzzword))

(fact "buzzword?: true when string contains given buzzword" 
  [candidate (map #(str "start " % " end") buzzwords)
   buzzword buzzwords]
  (buzzword? candidate buzzword))

(fact "buzzword?: false when string does not equal given buzzword" 
  [candidate non-buzzwords
   buzzword (rand-elems buzzwords)]
  (false? (buzzword? candidate buzzword)))

(fact "find-buzzwords: a list of buzzwords found in the candidate"
  [[candidate found] {"apple ajax orange" ["ajax"]
		      "apple ajax grape rest orange" ["ajax" "rest"]
		      "apple grape orange" nil}]
  (= found (find-buzzwords candidate buzzwords)))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'test.buzzer))
(.println *test-out*)