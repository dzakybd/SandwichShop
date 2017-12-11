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
        this.softdrink=new Softdrink();
    }

    public String CoffeeTaken(){
        return this.coffee.getProductName();
    }
    public String TeaTaken(){
        return this.tea.getProductName();
    }
    public String SoftdrinkTaken(){
        return this.softdrink.getProductName();
    }
}
