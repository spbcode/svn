package com.coderelated.designpatterns.behaviour.chainOfResponsibility;

public class ErrorLogProcessor extends LogProcessor{
    @Override
    public void log(String msg, int loglevel) {
        if(loglevel==ERROR){
            System.out.println(msg);
        }else{
            super.log(msg, loglevel);
        }
    }

    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
}
