(use 'vertx.core)

(def echo-response
  (handle [this buffer]
    (println "Net client receiving:" (str buffer))))

(doto (.createNetClient vertx)
  (.setSSL true)
  (.setTrustAll true)
  (. connect 1234
     (handle [this socket]
       (.dataHandler socket echo-response)
        (dotimes [i 10]
          (let [message (str "hello " i "\n")]
            (println "Net client sending:" message)
            (.write socket (new org.vertx.java.core.buffer.Buffer message)))))))
