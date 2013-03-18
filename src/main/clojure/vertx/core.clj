(ns vertx.core)
(println "vert.x core initializing")

;; setup for vertx

;(def vertx org.vertx.java.deploy.impl.VertxLocator/vertx)
;(def container org.vertx.java.deploy.impl.VertxLocator/container)
;(def event-bus (. vertx eventBus))

(defmacro handle
  [bindings & body]
  `(reify org.vertx.java.core.Handler
     (handle ~bindings ~@body)))


(defmacro defhandle
  [name & rest]
  `(def ~name (handle ~@rest)))

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

