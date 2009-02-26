(ns buzzer.rest-api (:use compojure))

(def buzzword-route (GET "/buzzword/:candidate"
  (if (= "ajax" (route :candidate)) 
    "true" "false")))



