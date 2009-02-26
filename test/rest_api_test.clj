(ns test.buzzer.rest-api (:use fact buzzer.rest-api 
			       compojure))

(fact "GET /buzzword/ajax: 'true'" []
  (= "true" (buzzword-route "GET" "/buzzword/ajax")))

(fact "GET /buzzword/cat: 'false'" []
  (= "false" (buzzword-route "GET" "/buzzword/cat")))

(.println *test-out* "test.buzzer.rest-api:")
(print-color-results (verify-facts 'test.buzzer.rest-api))
(.println *test-out*)

