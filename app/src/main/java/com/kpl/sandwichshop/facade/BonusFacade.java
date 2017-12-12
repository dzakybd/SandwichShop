package com.kpl.sandwichshop.facade;

/**
 * Created by w7 on 11/12/2017.
 */

public class BonusFacade {

    private Beverage coffee;
    private Beverage tea;
    private Beverage softdrink;

    public BonusFacade() {
        this.coffee = new Coffee();
        this.tea = new Tea();
        this.softdrink = new Softdrink();
    }

    public String getCoffee() {
        return this.coffee.getProductName();
    }

    public String getTea() {
        return this.tea.getProductName();
    }

    public String getSoftdrink() {
        return this.softdrink.getProductName();
    }
}
