(use 'vertx.core)

(doto (.createNetClient vertx)
  (.connect 1234 "localhost"
            (handle [this socket]
              (.dataHandler socket
                            (handle [this buffer]
                              (println "Net client receiving ")))
              (dorun     
               (for [i (range 10)
                     :let [message (str "hello" i "\n")]]
                 (do (print "Net client sending: " message)
                     (.write socket message)))))))

