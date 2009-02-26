(ns test.buzzer.rest-api (:use fact buzzer.rest-api 
			       compojure clj-http-client.core))

(defserver test-server
  {:port 8081} 
  "/*" buzzer-servlet)

(defn get-body [path]
  (last (http-get (str "http://localhost:8081" path))))

(fact "GET /buzzword/ajax: 'true' when a buzzword"
  [buzzword server-buzzwords]
  (= "true" (get-body (str "/buzzword/" buzzword))))

(fact "GET /buzzword/cat: 'false' when not a buzzword" 
  [non-buzzword ["apple" "orange" "grape" "cherry"]]
  (= "false" (get-body (str "/buzzword/" non-buzzword))))

(fact "GET /api-hits: number of hits api has received" []
  (get-body "/buzzword/not-a-buzzword")
  (not= "0" (get-body "/api-hits")))

(.println *test-out* "test.buzzer.rest-api:")
(try 
 (start test-server)
 (print-color-results (verify-facts 'test.buzzer.rest-api))
 (finally (stop test-server) 
	  (shutdown-agents )))
(.println *test-out*)