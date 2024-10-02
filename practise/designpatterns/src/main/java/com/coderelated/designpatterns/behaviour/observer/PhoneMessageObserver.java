package com.coderelated.designpatterns.behaviour.observer;

public class PhoneMessageObserver implements IObserver{
    @Override
    public void update(IObservable observable) {
        System.out.println(PhoneMessageObserver.class.getName()+":"+observable.getData());
    }
}
