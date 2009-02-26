(ns buzzer.rest-api 
  (:require (org.danlarkin [json :as json]))
  (:use buzzer compojure))

(def server-buzzwords ["ajax" "dsl" "rest"])

(def *api-hits* (agent 0))

(defservlet buzzer-servlet
  (GET "/buzzword/:candidate"
    (dosync (send *api-hits* inc))
    (json/encode-to-str 
     (not (empty? (find-buzzwords (route :candidate) server-buzzwords)))))

  (GET "/api-hits"
    (json/encode-to-str 
     @*api-hits*)))



