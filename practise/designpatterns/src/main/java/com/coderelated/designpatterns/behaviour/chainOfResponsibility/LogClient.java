package com.coderelated.designpatterns.behaviour.chainOfResponsibility;

public class LogClient {
    public static void main(String str[]){
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log("error",LogProcessor.ERROR);
    }
}
