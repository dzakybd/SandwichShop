package com.kpl.sandwichshop.builder;

import com.kpl.sandwichshop.models.Bread.Bread;
import com.kpl.sandwichshop.models.Filling.Filling;
import com.kpl.sandwichshop.singleton.Discount;

import java.util.List;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Sandwich {

    private Sandwich() {
    }

    private static Sandwich sandwich = new Sandwich();

    public static Sandwich getSandwich() {
        return sandwich;
    }

    private Bread bread;
    private List<Filling> fillings;

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void setFillings(List<Filling> fillings) {
        this.fillings = fillings;
    }

}
