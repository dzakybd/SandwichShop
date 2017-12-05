package com.kpl.sandwichshop.decorator;

/**
 * Created by Ilham Aulia Majid on 05-Dec-17.
 */

public abstract class Decorator {

    private String name;
    private Decorator decorator;

    public Decorator(Decorator decorator) {
        this.decorator = decorator;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDecorators() {
        String decoratorsName = " + " + this.name;
        if (decorator != null) {
            decoratorsName += decorator.getDecorators();
        }
        return decoratorsName;
    }


}
