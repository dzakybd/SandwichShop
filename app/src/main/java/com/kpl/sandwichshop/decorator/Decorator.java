package com.kpl.sandwichshop.decorator;

import com.google.auto.value.AutoValue;

import org.parceler.Parcel;
import org.parceler.ParcelFactory;
import org.parceler.ParcelProperty;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

@AutoValue
@Parcel
public abstract class Decorator {

    @ParcelProperty("name")
    String name;
    @ParcelProperty("price")
    int price;
    @ParcelProperty("Decorator")
    public Decorator decorator;

    @ParcelFactory
    public static Decorator create(String name) {
        if (name.contentEquals("Mayonnaise")) {
            return new MayoDecorator();
        }else if (name.contentEquals("Cheese Sauce")) {
            return new CheeseDecorator();
        }else if (name.contentEquals("BBQ Sauce")) {
            return new SauceDecorator();
        }else{
            return null;
        }
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

    public void addDecorator(Decorator decorator) {
        if (this.decorator == null) {
            this.decorator = decorator;
        } else {
            this.decorator.addDecorator(decorator);
        }
    }
}
