package com.kpl.sandwichshop.singleton;

/**
 * Created by zaki on 4/12/17.
 */

public class DiscountList {

    public static void checkDiscount(String code) {
        Discount discount = Discount.getDiscount();
        if (code.contentEquals("SHOP1")) {
            discount.setCode("SHOP1");
            discount.setPrice(2000);
        } else if (code.contentEquals("SHOP2")) {
            discount.setCode("SHOP2");
            discount.setPrice(3000);
        } else {
            discount.setCode("");
            discount.setPrice(0);
        }
    }

}
