package com.kpl.sandwichshop.builder;

import com.kpl.sandwichshop.models.Bread.Bread;
import com.kpl.sandwichshop.models.Filling.Filling;
import com.kpl.sandwichshop.observer.Observable;
import com.kpl.sandwichshop.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Sandwich implements Observable {

    public boolean ready;

    public Sandwich() {
    }

    private static Sandwich sandwich = new Sandwich();

    public static Sandwich getSandwich() {
        return sandwich;
    }

    private Bread bread;
    private List<Filling> fillings;
    private ArrayList<Observer> orders = new ArrayList<Observer>();

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

    @Override
    public void register(Observer observer) {
        orders.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        orders.remove(observer);
    }

    @Override
    public boolean getReady() {
        return ready;
    }

    @Override
    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public void notifyObserver() {
        for (Observer order : orders) {
            order.update();
        }
    }

}
