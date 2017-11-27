package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 27-Nov-17.
 */

public interface DiscountType {

    public int getDiscountedPrice(int price, int value);

}
