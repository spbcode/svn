package com.coderelated.designpatterns.behaviour.chainOfResponsibility;

public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }

    public void log(String msg,int loglevel){
        if(loglevel==INFO){
            System.out.println(msg);
        }else{
            super.log(msg, loglevel);
        }
    }
}
