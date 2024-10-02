package com.coderelated.designpatterns.behaviour.observer;

import java.util.HashSet;

public class StockObserverClient {
    public static void main(String args[]){
        StockObservable stockObservable = new StockObservable(new HashSet<>());
        IObserver emailObserver = new EmailObserver();
        IObserver phoneMessageObserver = new PhoneMessageObserver();
        stockObservable.addObserver(emailObserver);
        stockObservable.addObserver(phoneMessageObserver);
        stockObservable.setData(10);
    }
}
