(ns test.buzzer.rest-api (:use fact buzzer.rest-api 
			       compojure clj-http-client.core))

(defserver test-server
  {:port 8081} 
  "/*" buzzer-servlet)

(fact "GET /buzzword/ajax: 'true'" []
  (= "true" (last (http-get "http://localhost:8081/buzzword/ajax"))))

(fact "GET /buzzword/cat: 'false'" []
  (= "false" (last (http-get "http://localhost:8081/buzzword/cat"))))

(.println *test-out* "test.buzzer.rest-api:")
(start test-server)
(print-color-results (verify-facts 'test.buzzer.rest-api))
(stop test-server)
(.println *test-out*)

