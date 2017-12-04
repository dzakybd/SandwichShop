package com.kpl.sandwichshop.models;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Filling {

    String name;
    int price;
    int drawable;
    String category;

    public Filling(String name, int price, String category, int drawable){
        this.name = name;
        this.price = price;
        this.category = category;
        this.drawable=drawable;
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

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}