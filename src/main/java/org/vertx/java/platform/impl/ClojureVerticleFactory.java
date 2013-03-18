/*
 * Copyright 2011-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vertx.java.platform.impl;

import org.vertx.java.core.Vertx;
import org.vertx.java.core.logging.Logger;
import org.vertx.java.platform.Container;
import org.vertx.java.platform.Verticle;
import org.vertx.java.platform.VerticleFactory;


public class ClojureVerticleFactory implements VerticleFactory {

    private ClassLoader classLoader;

    public ClojureVerticleFactory() {
    }


	@Override
	public void init(Vertx vertx, Container container, ClassLoader cl) {
		classLoader = cl;
	}

	@Override
	public Verticle createVerticle(String main) throws Exception {
        return new ClojureVerticle(main, classLoader);
	}

	@Override
	public void reportException(Logger logger, Throwable t) {
        logger.error("Unexpected exception in Clojure verticle", t);
	}

	@Override
	public void close() {

	}
}
