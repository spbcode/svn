package com.coderelated.designpatterns.behaviour.observer;

import java.util.Set;

public class StockObservable implements IObservable{
    private Set<IObserver> observers;
    private int data;

    public StockObservable(Set<IObserver> observers) {
        this.observers = observers;
    }

    public synchronized void addObserver(IObserver observer){
        if(observer==null) throw new NullPointerException("observer is Null");
        if(!observers.contains(observer)) observers.add(observer);
    }

    public synchronized void removeObserver(IObserver observer){
        this.observers.remove(observer);
    }

    public void publish(){
        synchronized (this){
            observers.forEach(observer -> observer.update(this));
        }
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        publish();
    }
}
