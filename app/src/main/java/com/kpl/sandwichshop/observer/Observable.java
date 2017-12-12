package com.kpl.sandwichshop.observer;

/**
 * Created by Hendry on 12/5/2017.
 */

public interface Observable {

    void register(Observer observer);

    void unregister(Observer observer);

    void notifyObserver();
}
