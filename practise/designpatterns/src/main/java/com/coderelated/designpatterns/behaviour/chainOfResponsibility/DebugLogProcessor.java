package com.coderelated.designpatterns.behaviour.chainOfResponsibility;

public class DebugLogProcessor extends LogProcessor{
    @Override
    public void log(String msg, int loglevel) {
        if(loglevel==DEBUG){
            System.out.println(msg);
        }else{
            super.log(msg, loglevel);
        }
    }

    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
}
