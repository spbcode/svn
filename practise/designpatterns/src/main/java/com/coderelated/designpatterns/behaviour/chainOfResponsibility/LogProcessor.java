package com.coderelated.designpatterns.behaviour.chainOfResponsibility;

public abstract class LogProcessor {

    public static int INFO=0;
    public static int DEBUG=1;
    public static int ERROR=2;
    public void log(String msg,int loglevel){
        if(next!=null){
            next.log(msg,loglevel);
        }
    }

    private LogProcessor next;

    public LogProcessor(LogProcessor nextProcessor) {
        next=nextProcessor;
    }

}
