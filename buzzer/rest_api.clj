(ns buzzer.rest-api (:use compojure))

(defservlet buzzer-servlet
  (GET "/buzzword/:candidate"
    (if (= "ajax" (route :candidate)) 
      "true" "false")))



