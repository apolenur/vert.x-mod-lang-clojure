(use 'vertx.core)

(def address "example.address") 
(def count (atom 0)) 


(.setPeriodic vertx 2000
              (handle [this _]
                (let [message (str "some-message-" (swap! count inc))]
                  (.send event-bus address message)
                  (println "Sent message" message))))

