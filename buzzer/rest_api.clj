(ns buzzer.rest-api (:use buzzer compojure))

(def server-buzzwords ["ajax" "dsl" "rest"])

(defservlet buzzer-servlet
  (GET "/buzzword/:candidate"
    (if (empty? (find-buzzwords (route :candidate) server-buzzwords)) 
      "false" "true")))



