(use 'vertx.core)

(defn dump-header [[key value]]
  (println key ":" value))

(defn dump-req [req]
  (println "Got request:" (. req uri))
  (println "Headers are:")
  (dorun
   (map dump-header (. req headers))))

(defn header [response name value]
    (.put (.headers response)
          name value))

(defn content-type [response content-type]
  (header response "Content-Type" content-type))

(doto (.createHttpServer vertx)
  (.requestHandler
   (handle [this req]
     (dump-req req)
     (doto (. req response)
       (content-type "text/html; charset=UTF-8")
       (.end  "<html><body><h1>Hello from vert.x!</h1></body></html>"))))  
  (.listen 8080 "localhost"))

