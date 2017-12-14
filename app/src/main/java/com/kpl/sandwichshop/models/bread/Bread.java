package com.kpl.sandwichshop.models.bread;

import com.google.auto.value.AutoValue;

import org.parceler.Parcel;
import org.parceler.ParcelFactory;
import org.parceler.ParcelProperty;

/**
 * Created by zaki on 4/12/17.
 */

@AutoValue
@Parcel
public abstract class Bread {

    @ParcelProperty("getName")
    public abstract String getName();

    @ParcelProperty("getSandwichPrice")
    public abstract int getPrice();

    @ParcelProperty("getDrawable")
    public abstract int getDrawable();

    @ParcelFactory
    public static Bread create(String getName) {
        if (getName.contentEquals("Flat bread")) {
            return new FlatBread();
        }else if (getName.contentEquals("Bun bread")) {
            return new BunBread();
        }if (getName.contentEquals("Long bread")) {
            return new LongBread();
        } else {
            return null;
        }
    }

}