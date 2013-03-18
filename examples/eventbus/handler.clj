(use 'vertx.core)

(def address "example.address")

(.registerHandler event-bus address
                  (handle [this message]
                    (println "Received message" (. message body))))

