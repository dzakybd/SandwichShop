package com.kpl.sandwichshop.decorator;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

public class CheeseDecorator extends Decorator {

    public CheeseDecorator() {
        this(null);
    }

    public CheeseDecorator(Decorator decorator) {
        super(decorator);
        setName("Cheese");
        setPrice(250);
    }
}
