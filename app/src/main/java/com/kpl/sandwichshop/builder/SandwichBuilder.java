package com.kpl.sandwichshop.builder;

import com.kpl.sandwichshop.models.Bread;
import com.kpl.sandwichshop.models.Filling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class SandwichBuilder {

    private Sandwich sandwich;
    private Bread bread;
    private List<Filling> fillings;

    public SandwichBuilder() {
        fillings = new ArrayList<>();
    }

    public Sandwich build() {
        Sandwich sandwich = new Sandwich();
        sandwich.setBread(bread);
        sandwich.setFillings(fillings);
        return sandwich;
    }

    public SandwichBuilder setBread(Bread bread) {
        this.bread = bread;
        return this;
    }

    public SandwichBuilder addFilling(Filling filling) {
        this.fillings.add(filling);
        return this;
    }

    public SandwichBuilder removeFilling(int index) {
        this.fillings.remove(index);
        return this;
    }

}
