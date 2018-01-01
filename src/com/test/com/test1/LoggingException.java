package com.test.com.test1;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

class LogException extends Exception {
    private static Logger logger=Logger.getLogger("LogWxception");

    public LogException() {
        StringWriter trace=new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

public class LoggingException {
    public static void main(String[] args) {
        try{
            throw new LogException();
        }catch (LogException e){
            System.err.print("Caught "+e);
        }
        try{
            throw new LogException();
        }catch (LogException e){
            System.err.print("Caught "+e);
        }
    }
}
