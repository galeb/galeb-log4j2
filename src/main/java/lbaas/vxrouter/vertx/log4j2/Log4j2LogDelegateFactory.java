/* 
 * Copyright (c) 2014 The original author or authors.
 * All rights reserved.
 */
package lbaas.vxrouter.vertx.log4j2;

import org.vertx.java.core.logging.impl.LogDelegate;
import org.vertx.java.core.logging.impl.LogDelegateFactory;

public class Log4j2LogDelegateFactory implements LogDelegateFactory {

    public LogDelegate createDelegate(String name) {
        return new Log4j2LogDelegate(name);
    }

}
