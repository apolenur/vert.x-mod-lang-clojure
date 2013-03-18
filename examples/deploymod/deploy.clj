(use 'vertx.core)

(def config (new org.vertx.java.core.json.JsonObject
                 {"some-var" "hello"}))

(-> container
    (deployModule "org.foo.MyMod-v1.0" config 1
                  (handle [this deployment-id]
                    (println "This gets called when deployment is complete,"
                             "deployment id is"
                             deployment-id))) )
