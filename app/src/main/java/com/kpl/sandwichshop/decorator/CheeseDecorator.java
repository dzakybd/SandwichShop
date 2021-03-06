package com.kpl.sandwichshop.decorator;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

public class CheeseDecorator extends Decorator {

    public CheeseDecorator() {
        this(null);
    }

    public CheeseDecorator(Decorator decorator) {
        this.decorator = decorator;
        setName("Cheese Sauce");
        setPrice(2000);
    }
}
