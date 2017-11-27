package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public interface DiscountType {

    public int getFinalPrice(int price, int value);

}
