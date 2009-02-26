(ns buzzer.rest-api (:use buzzer compojure))

(def server-buzzwords ["ajax" "dsl" "rest"])

(def *api-hits* (agent 0))

(defservlet buzzer-servlet
  (GET "/buzzword/:candidate"
    (dosync (send *api-hits* inc))
    (if (empty? (find-buzzwords (route :candidate) server-buzzwords)) 
      "false" "true"))

  (GET "/api-hits"
    (str @*api-hits*)))



