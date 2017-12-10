package com.kpl.sandwichshop.decorator;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

public class SauceDecorator extends Decorator {

    public SauceDecorator(){
        this(null);
    }

    public SauceDecorator(Decorator decorator) {
        super(decorator);
        setName("BBQ Sauce");
        setPrice(2000);
    }
}
