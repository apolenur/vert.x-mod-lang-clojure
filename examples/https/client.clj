(use 'vertx.core)

(defhandle dump-buffer
  [this buffer]
  (println (str buffer)))

(doto (.createHttpClient vertx)
  (.setPort 4443)
  (.setSSL true)
  (.setTrustAll true)
  (.getNow "/"
           (handle [this resp]
                    (.dataHandler resp dump-buffer))))

