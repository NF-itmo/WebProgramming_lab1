package org.web1.utils;

import java.io.IOException;
import java.util.logging.*;

public class SimpleLogger {
    static Logger logger = Logger.getLogger(Logger.class.getName());

    public static Logger create(){
        try {
            Handler fileHandler = new FileHandler("log.log");
            fileHandler.setFormatter(fileHandler.getFormatter());
            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);

            return logger;
        } catch (SecurityException | IOException e) {
            throw new RuntimeException("Can't init logger");
        }
    }
}