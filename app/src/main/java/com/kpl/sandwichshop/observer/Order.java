package com.kpl.sandwichshop.observer;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Order implements Observer {

    private Observable observable = null;

    public Order(Observable observable){
        this.observable = observable;
    }

    @Override
    public String update() {
        if(observable.getReady()){
            // Stop receiving notifications
            observable.unregister(this);
            return "Your order is ready to collect";
        }
        else {
            return "Your sandwich will be ready very soon";
        }
    }
}
