package com.kpl.sandwichshop.models.Filling;

import com.google.auto.value.AutoValue;

import org.parceler.Parcel;
import org.parceler.ParcelFactory;
import org.parceler.ParcelProperty;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */
@AutoValue
@Parcel
public abstract class Filling {

    @ParcelProperty("getName") public abstract String getName();
    @ParcelProperty("getPrice") public abstract int getPrice();
    @ParcelProperty("getDrawable") public abstract int getDrawable();
    @ParcelProperty("getCategory") public abstract String getCategory();

    @ParcelFactory
    public static Filling create(String getName) {
        if(getName.contentEquals("Beef")) return new Beef();
        else if(getName.contentEquals("Chicken meat")) return new Chicken();
        else if(getName.contentEquals("Lettuce")) return new Lettuce();
        else if(getName.contentEquals("Tomato")) return new Tomato();
        else if(getName.contentEquals("Cheese")) return new Cheese();
        else if(getName.contentEquals("Mayonnaise")) return new Mayonnaise();
        else return null;
    }
}