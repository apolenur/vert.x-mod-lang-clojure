(ns clj-examples.echo.server
  (:require [vertx.core :as vcore]
 ))


(vcore/defhandle pumpHandler
  [this socket]
  (vcore/pump socket socket true))



;(def netServer 
;  (sock-listen vertx "localhost" 1234 
;               (vcore/handle [this socket] 
;                             (vcore/pump socket socket true))))
(def netServer 
  (vcore/sock-listen vcore/vertx "localhost" 1234 pumpHandler))

;(vcore/net-server-stop netServer)




