/*
 * Copyright (c) 2014 Globo.com - ATeam
 * All rights reserved.
 *
 * This source is subject to the Apache License, Version 2.0.
 * Please see the LICENSE file for more information.
 *
 * Authors: See AUTHORS file
 *
 * THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
 * PARTICULAR PURPOSE.
 */
package com.globo.galeb.vertx.log4j2;

import org.vertx.java.core.logging.impl.LogDelegate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2LogDelegate implements LogDelegate {

    private final Logger logger;

    Log4j2LogDelegate(final String name) {
        logger = LogManager.getLogger(name);
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public void fatal(final Object message) {
        logger.fatal(message);
    }

    public void fatal(final Object message, final Throwable t) {
        logger.fatal(message, t);
    }

    public void error(final Object message) {
        logger.error(message);
    }

    public void error(final Object message, final Throwable t) {
        logger.error(message, t);
    }

    public void warn(final Object message) {
        logger.warn(message);
    }

    public void warn(final Object message, final Throwable t) {
        logger.warn(message, t);
    }

    public void info(final Object message) {
        logger.info(message);
    }

    public void info(final Object message, final Throwable t) {
        logger.info(message, t);
    }

    public void debug(final Object message) {
        logger.debug(message);
    }

    public void debug(final Object message, final Throwable t) {
        logger.debug(message, t);
    }

    public void trace(final Object message) {
        logger.trace(message);
    }

    public void trace(final Object message, final Throwable t) {
        logger.trace(message, t);
    }
}