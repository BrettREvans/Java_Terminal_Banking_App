package com.revature.project.zero;
//import org.apache.log4j.FileAppender;
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//import org.apache.log4j.SimpleLayout;

// Main: the class that handles starting the application.
//       it also holds the debug.txt logger for uses around the program
public class Main {
    //public static final Logger logger = Logger.getLogger(Main.class);

    //main: The driver class for the whole java project
    //       without it nothing works. calls runApplication
    public static void main(String[] args) {
        setupLogger();
        ApplicationRun.runApplication();
    }

    //setupLogger: this method holds the logger setup
    //             exists to keep main clean
    private static void setupLogger() {
//        logger.setLevel(Level.DEBUG);
//        FileAppender fa = new FileAppender();
//        fa.setFile("debug.txt");
//        fa.setLayout(new SimpleLayout());
//        logger.addAppender(fa);
//        fa.activateOptions();
    }

    //LoggerMethods
    //logMessage: this method takes a log level and a message to log to debug.txt
    public static void logMessage(String logType, String message) {
        switch (logType){
            case "debug":
                //logger.debug(message);
                break;
            case"info":
                //logger.info(message);
                break;
            case"warn":
                //logger.warn(message);
                break;
            case"error":
                //logger.error(message);
                break;
            case"fatal":
                //logger.fatal(message);
                break;
        }
    }

    //logDash: creates a clear break in the debug file for readability
    public static void logDash() {
//        logger.debug("----------------------------------------------------------");
    }
}
