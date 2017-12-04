package com.kpl.sandwichshop.singleton;

import com.kpl.sandwichshop.builder.Sandwich;
import com.kpl.sandwichshop.strategy.DiscountType;
import com.kpl.sandwichshop.strategy.NoDiscount;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class Discount {

    private int price;
    private String code;

    private Discount() {
    }

    private static Discount discount = new Discount();

    public static Discount getDiscount() {
        return discount;
    }

    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
