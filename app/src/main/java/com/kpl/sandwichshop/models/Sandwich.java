package com.kpl.sandwichshop.models;

import java.util.List;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Sandwich {

    private Bread bread;
    private List<Filling> fillings;

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

    public int getPrice() {
        int breadPrice = this.bread.getPrice();
        int fillingsPrice = 0;
        for (Filling filling : this.fillings) {
            fillingsPrice += filling.getPrice();
        }
        return breadPrice + fillingsPrice;
    }
}