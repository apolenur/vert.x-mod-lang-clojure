# Clojure support for Vert.x 2.0

This is a port of git://github.com/orb/vert.x.git to make it run on Vert.x
2.0. It is an early prototype work, but it does allow running sample Clojure
verticles.

How to try

1.Build

	gradle install

2.Add following 2 lines to $VERTX_HOME/conf/langs.properties 

	clojure=com.polenur~vertx-lang-clojure~0.1.0-SNAPSHOT:org.vertx.java.platform.impl.ClojureVerticleFactory

	.clj=clojure

3.Run echo example

	cd to examples and run

	vertx run echo/echo-server.clj





