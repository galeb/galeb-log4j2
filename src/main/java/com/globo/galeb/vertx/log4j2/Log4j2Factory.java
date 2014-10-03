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

import com.hazelcast.logging.AbstractLogger;
import com.hazelcast.logging.ILogger;
import com.hazelcast.logging.LogEvent;
import com.hazelcast.logging.LoggerFactorySupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.spi.ExtendedLogger;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Log4j2Factory extends LoggerFactorySupport {

    private static final String FQCN = Log4j2Logger.class.getName();

    @Override
    protected ILogger createLogger(String name) {
        return new Log4j2Logger(LogManager.getContext().getLogger(name));
    }

    class Log4j2Logger extends AbstractLogger {
        private final ExtendedLogger logger;

        public Log4j2Logger(ExtendedLogger logger) {
            this.logger = logger;
        }

        public void log(LogEvent logEvent) {
            LogRecord logRecord = logEvent.getLogRecord();
            Level level = logEvent.getLogRecord().getLevel();
            String message = logRecord.getMessage();
            Throwable thrown = logRecord.getThrown();
            log(level, message, thrown);
        }

        public void log(Level level, String message) {
            logger.logIfEnabled(FQCN, getLevel(level), null, message);
        }

        public void log(Level level, String message, Throwable thrown) {
            logger.logIfEnabled(FQCN, getLevel(level), null, message, thrown);
        }

        public Level getLevel() {
            if (logger.isDebugEnabled()) {
                return Level.FINEST;
            } else if (logger.isInfoEnabled()) {
                return Level.INFO;
            } else if (logger.isWarnEnabled()) {
                return Level.WARNING;
            } else {
                return Level.SEVERE;
            }
        }

        public boolean isLoggable(Level level) {
            if (Level.OFF == level) {
                return false;
            } else {
                return logger.isEnabled(getLevel(level), null);
            }
        }

        private org.apache.logging.log4j.Level getLevel(Level level) {
            if (Level.SEVERE == level) {
                return org.apache.logging.log4j.Level.ERROR;
            } else if (Level.WARNING == level) {
                return org.apache.logging.log4j.Level.WARN;
            } else if (Level.INFO == level) {
                return org.apache.logging.log4j.Level.INFO;
            } else if (Level.CONFIG == level) {
                return org.apache.logging.log4j.Level.INFO;
            } else if (Level.FINE == level) {
                return org.apache.logging.log4j.Level.DEBUG;
            } else if (Level.FINER == level) {
                return org.apache.logging.log4j.Level.DEBUG;
            } else if (Level.FINEST == level) {
                return org.apache.logging.log4j.Level.DEBUG;
            } else {
                return org.apache.logging.log4j.Level.INFO;
            }
        }
    }
}
