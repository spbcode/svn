package com.coderelated.designpatterns.behaviour.observer;

public class EmailObserver implements IObserver{
    @Override
    public void update(IObservable observable) {
        System.out.println(EmailObserver.class.getName()+":"+observable.getData());
    }
}
