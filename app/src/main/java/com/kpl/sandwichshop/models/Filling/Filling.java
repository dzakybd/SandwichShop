package com.kpl.sandwichshop.models.Filling;

import com.google.auto.value.AutoValue;

import org.parceler.Parcel;
import org.parceler.ParcelFactory;
import org.parceler.ParcelProperty;

/**
 * Created by zaki on 4/12/17.
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
        if(getName.contentEquals("Beef")) { return new Beef(); }
        else if(getName.contentEquals("Chicken meat")) { return new Chicken(); }
        else if(getName.contentEquals("Turkeys")) { return new Turkeys(); }
        else if(getName.contentEquals("Bacon")) { return new Bacon(); }
        else if(getName.contentEquals("Ham")) { return new Ham(); }
        else if(getName.contentEquals("Salmon")) { return new Salmon(); }
        else if(getName.contentEquals("Shrimp")) { return new Shrimp(); }
        else if(getName.contentEquals("Octopus")) { return new Octopus(); }
        else if(getName.contentEquals("Egg")) { return new Egg(); }
        else if(getName.contentEquals("Lettuce")) { return new Lettuce(); }
        else if(getName.contentEquals("Cabbage")) { return new Cabbage(); }
        else if(getName.contentEquals("Peppers")) { return new Peppers(); }
        else if(getName.contentEquals("Onion")) { return new Onion(); }
        else if(getName.contentEquals("Garlic")) { return new Garlic(); }
        else if(getName.contentEquals("Cucumber")) { return new Cucumber(); }
        else if(getName.contentEquals("Mushroom")) { return new Mushroom(); }
        else if(getName.contentEquals("Tomato")) { return new Tomato(); }
        else if(getName.contentEquals("Cheese")) { return new Cheese(); }
        else if(getName.contentEquals("Mayonnaise")) { return new Mayonnaise(); }
        else if(getName.contentEquals("Sauce")) { return new Sauce(); }
        else if(getName.contentEquals("Salt")) { return new Salt(); }
        else if(getName.contentEquals("Pepper")) { return new Pepper(); }
        else { return null; }
    }
}