package org.example;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class Log {
    public Logger logger;
    FileHandler fileHandler;
    public Log(String file_name) throws SecurityException, IOException{
        File file = new File(file_name);
        fileHandler= new FileHandler(file_name, true);
        logger = Logger.getLogger("logger");
        logger.addHandler(fileHandler);
        logger.setLevel(Level.INFO);
        SimpleFormatter formatter = new SimpleFormatter(){
            private static final String format = "[%1$tF %1$tT] [%2$-7s] %3$s %n"; // [#2$-7s]
            @Override
            public synchronized String format(LogRecord lr){
                return String.format(format,
                        new Date(lr.getMillis()),
                        lr.getLevel().getName(),
                        lr.getMessage());
            }
        };
        fileHandler.setFormatter(formatter);

    }
}
