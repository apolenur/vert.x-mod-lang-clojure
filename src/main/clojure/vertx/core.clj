(ns vertx.core
  (:import (org.vertx.java.core Vertx Handler AsyncResultHandler)
           (org.vertx.java.core.http HttpServerRequest RouteMatcher)
           (org.vertx.java.core.streams Pump)
           (clojure.lang ArityException)))

(println "vert.x core initializing")


;(def pmf org.vertx.java.platform.PlatformLocator/factory)

(defn create-platform-manager[]
    (.createPlatformManager org.vertx.java.platform.PlatformLocator/factory))

(def pm (create-platform-manager))

(def vertx (.getVertx pm))

(defmacro handle
  [bindings & body]
  `(reify org.vertx.java.core.Handler
     (handle ~bindings ~@body)))


(defmacro defhandle
  [name & rest]
  `(def ~name (handle ~@rest)))


(defn net-server-create
  [vertx]
  (.createNetServer vertx))

(defn net-server-stop
  [net-server]
  (.close net-server))

(defn sock-listen 
  [vertx host port handler]
  (-> vertx .createNetServer (.connectHandler handler) (.listen port host)))

(defn pump
  "Create a Pump on the passed two sockets, takes an optional parameter for whether start the pump
   immediately, Default false."
  ([sock1 sock2]
     (Pump/createPump sock1 sock2))
  ([sock1 sock2 start]
     (if start
       (.start (pump sock1 sock2))
       (pump sock1 sock2))))

;; undeployModule
;; undeployWorkerVerticle
;; undeployVerticle
(defmacro deployModule [container & args]
  `(do
     (.deployModule ~container  ~@args)
     container))

(defmacro deployVerticle [container & args]
  `(do
     (.deployVerticle ~container  ~@args)
     container))

(defmacro deployWorkerVerticle [container & args]
  `(do
     (.deployWorkerVerticle ~container  ~@args)
     container))


