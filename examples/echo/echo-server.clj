(ns echo.echo-server
  (:use [vertx.core]))
;(use 'vertx.core)

(doto (.createNetServer vertx)
  (.connectHandler
   (handle [this socket]
     (println "pre pump")
     (.start (org.vertx.java.core.streams.Pump/createPump socket socket))
     (println "post pump")))
  (.listen 1234 "localhost"))





