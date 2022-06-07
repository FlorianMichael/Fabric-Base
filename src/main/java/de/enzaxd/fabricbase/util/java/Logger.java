package de.enzaxd.fabricbase.util.java;

import de.enzaxd.fabricbase.FabricBase;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class Logger {

    private final static org.apache.logging.log4j.Logger logger = LogManager.getLogger(FabricBase.CLIENT_NAME);

    public static void info(final String message) {
        raw(Level.INFO, message);
    }

    public static void error(final String message) {
        raw(Level.ERROR, message);
    }

    private static void raw(final Level type, final String message) {
        logger.log(type, message);
    }
}
