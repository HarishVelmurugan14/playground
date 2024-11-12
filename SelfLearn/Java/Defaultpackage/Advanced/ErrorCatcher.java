package SelfLearn.Java.Defaultpackage.Advanced;

import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ErrorCatcher {
    private static final Logger LOGGER = Logger.getLogger(ErrorCatcher.class.getName());

    public static void main(String[] args) {
        returnVoid();
        String s = returnSomething();
        System.out.println(s);
    }

    public static <T> T executeWithTryCatch(Callable<T> codeBlock, Level severityLevel,
                                            String logMessage, T defaultReturnValue) {
        try {
            return codeBlock.call();
        } catch (Exception ex) {
            LOGGER.log(severityLevel, logMessage, ex);
            return defaultReturnValue;
        }
    }

    public static void executeWithTryCatch(Runnable codeBlock, Level severityLevel, String logMessage) {
        try {
            codeBlock.run();
        } catch (Exception ex) {
            LOGGER.log(severityLevel, logMessage, ex);
        }
    }

    private static void returnVoid() {
        executeWithTryCatch(() -> {
            //Execute something without returning
        }, Level.SEVERE, "Exception while sending async keyword submission logs");
    }

    private static String returnSomething() {
        return executeWithTryCatch(() -> {
            // Execute something that returns something (any object)
            return "Some String";
        }, Level.SEVERE, "Exception while building async keyword submission logs", null);
    }
}
