package com.kpl.sandwichshop;

import com.kpl.sandwichshop.decorator.Decorator;
import com.kpl.sandwichshop.models.bread.Bread;
import com.kpl.sandwichshop.models.filling.Filling;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */
@Parcel
public class Sandwich extends Decorator {

    Bread bread;
    List<Filling> fillings = new ArrayList<>();

    public Sandwich() {
        this(null);
    }

    public Sandwich(Decorator decorator) {
        setName("Sandwich");
        setPrice(0);
    }

    public String getDecorator() {
        if (decorator == null) {
            return "null";
        }
        return decorator.toString();
    }

    public void removeDecorator() {
        this.decorator = null;
    }

    public void addFilling(Filling filling) {
        this.fillings.add(filling);
    }

    public void removeFilling(int index) {
        this.fillings.remove(index);
    }

    public int getSandwichPrice() {
        int total = 0;
        for (Filling filling : fillings) {
            total += filling.getPrice();
        }
        return total;
    }

    public int getToppingPrice() {
        return super.getPrice();
    }

    @Override
    public int getPrice() {
        return this.getSandwichPrice() + this.getToppingPrice();
    }

    public void changePosition(int oldposition, int newposition) {
        fillings.add(newposition, fillings.remove(oldposition));
    }

    public Bread getBread() {
        return bread;
    }

    public List<Filling> getFillings() {
        return fillings;
    }

    public void setBread(Bread bread) {
        this.bread = bread;
    }

    public int sizeFilling() {
        return this.fillings.size();
    }

}
