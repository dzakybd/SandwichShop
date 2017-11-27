package com.kpl.sandwichshop.strategy;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class MoneyDiscount implements DiscountType {

    @Override
    public int getDiscountedPrice(int price, int value) {
        int discountedPrice = (price - value);
        return (discountedPrice > 0) ? discountedPrice : 0;
    }

}
