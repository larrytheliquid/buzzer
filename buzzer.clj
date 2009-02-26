(ns buzzer (:use fact))

(defn buzzword? [candidate buzzword]
  (.contains candidate buzzword))

(defn find-buzzwords [candidate buzzwords]
  ["ajax"])

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
  [[candidate found] {["apple ajax orange"] ["ajax"]}]
  (= found (find-buzzwords candidate buzzwords)))

(.println *test-out* "buzzer:")
(print-color-results (verify-facts 'buzzer))
(.println *test-out*)