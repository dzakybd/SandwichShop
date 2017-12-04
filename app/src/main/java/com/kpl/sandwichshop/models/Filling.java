package com.kpl.sandwichshop.models;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Filling {

    public String name;
    public int price;
    public String category;

    public Filling(String name, int price, String category){
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
