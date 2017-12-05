package com.kpl.sandwichshop.decorator;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

public class MayoDecorator extends Decorator {

    public MayoDecorator() {
        this(null);
    }

    public MayoDecorator(Decorator decorator) {
        super(decorator);
        setName("Mayonnaise");
    }
}
