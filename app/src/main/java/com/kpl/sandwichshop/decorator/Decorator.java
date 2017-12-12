package com.kpl.sandwichshop.decorator;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

public abstract class Decorator {

    private String name;
    private int price;
    private Decorator decorator;

    public Decorator(Decorator decozrator) {
        this.decorator = decorator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        String decoratorsName = " + " + name;
        if (decorator != null) {
            decoratorsName += decorator.getName();
        }
        return decoratorsName;
    }

    public int getPrice() {
        int decoratorsPrice = price;
        if (decorator != null) {
            decoratorsPrice += decorator.getPrice();
        }
        return decoratorsPrice;
    }


}
