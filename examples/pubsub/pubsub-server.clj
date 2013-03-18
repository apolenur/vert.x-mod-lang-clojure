(use 'vertx.core)

;; . form seems to format a little better
(doto (.createNetServer vertx)
  (.connectHandler
   (handle [this socket]
     (. socket dataHandler
        (org.vertx.java.core.parsetools.RecordParser/newDelimited
         "\n"
         (handle [this buffer]
           (let [[command topic-name arg]
                 (-> (str buffer)
                     (.trim "\\,")
                     (.split))

                 topic-set
                 (-> vertx
                     (.sharedData)
                     (.getSet topic-name))
                 
                 write-handle
                 (.writeHandlerID socket)]
             
             (println "[" command "][" topic-name "]")

             (cond
              (= "subscribe" command)
              (.add topic-set write-handle)
              
              (= "unsubscribe" command)
              (.remove topic-set write-handle)

              (= "publish" command)
              (dorun
               (for [actor-id topic-set]
                 (.publish event-bus
                           actor-id
                           (new org.vertx.java.core.buffer.Buffer arg)))))))))))
  
  (.listen 1234))
