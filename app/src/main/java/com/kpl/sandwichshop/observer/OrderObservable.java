package com.kpl.sandwichshop.observer;

import com.kpl.sandwichshop.Order;

import java.util.ArrayList;

/**
 * Created by Hendry on 12/12/2017.
 */

public class OrderObservable implements Observable {

    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private Order order;

    public OrderObservable(Order order) {
        this.order = order;
    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(order);
        }
    }
}
