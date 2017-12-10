package com.kpl.sandwichshop.facade;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Beverage {

    public Coffee coffee;
    public Tea tea;
    public Softdrink softdrink;

    public Beverage() {
        this.coffee = new Coffee();
        this.tea = new Tea();
        this.softdrink=new Softdrink();
    }

    public void CofeeBonus(){
        coffee.getCoffee();
    }
    public void TeaBonus(){
        tea.getTea();
    }
    public void SoftdrinkBonus(){
        softdrink.getSoftdrink();
    }
}
