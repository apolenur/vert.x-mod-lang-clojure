(use 'vertx.core)

(def pump-handler
  (handle [this socket]
    (.start (org.vertx.java.core.streams.Pump/createPump socket socket))))

(doto (.createNetServer vertx)
  (.setSSL true)
  (.setKeyStorePath "server-keystore.jks")
  (.setKeyStorePassword "wibble")
  (.connectHandler pump-handler)
  (.listen 1234 "localhost"))

