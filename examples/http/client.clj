(use 'vertx.core)

(doto (.createHttpClient vertx)
  (.setPort 8080)
  (. getNow "/"
     (handle [this response]
       (. response bodyHandler
          (handle [this buffer]
            (println "Got data" (str buffer))))
       )))


