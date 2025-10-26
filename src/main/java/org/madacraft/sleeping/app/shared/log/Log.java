package org.madacraft.sleeping.app.shared.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum Log {
    LOGGER;

    private final Logger logger = LogManager.getLogger(Log.class);

    public Logger getLogger() {
        return logger;
    }
}
