# Clojure support for Vert.x 2.0

This is a port of git://github.com/orb/vert.x.git to make it run on Vert.x
2.0

This is early prototpe work, but it does allow running sample Clojure
verticles.

Build using 

gradle install

Add following 2 lines to $VERTX_HOME/conf/langs.properties 

clojure=com.polenur~vertx-lang-clojure~0.1.0-SNAPSHOT:org.vertx.java.platform.impl.ClojureVerticleFactory

.clj=clojure

Cd to examples and run

vertx run echo/echo-server.clj





