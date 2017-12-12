package com.kpl.sandwichshop.builder;

import com.kpl.sandwichshop.models.Bread.Bread;
import com.kpl.sandwichshop.models.Filling.Filling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public class Sandwich {

    private Bread bread;
    private List<Filling> fillings = new ArrayList<>();

    public void addFilling(Filling filling){
        this.fillings.add(filling);
    }

    public void removeFilling(int index){
        this.fillings.remove(index);
    }

    public int getPrice(){
        int total = 0;
        for (Filling filling : fillings) {
            total += filling.getPrice();
        }
        return total;
    }

    public void changePosition(int oldposition, int newposition){
        fillings.add(newposition, fillings.remove(oldposition));
    }

    public Bread getBread() {
        return bread;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public int sizeFilling(){
        return this.fillings.size();
    }

}
