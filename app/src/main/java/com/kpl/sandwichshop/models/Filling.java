package com.kpl.sandwichshop.models;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public abstract class Filling {

    public String name;
    public int price;
    public int category;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCategory() {
        return category;
    }
}
