package com.kpl.sandwichshop.singleton;

import com.kpl.sandwichshop.builder.Sandwich;

/**
 * Created by Ilham Aulia Majid on 28-Nov-17.
 */

public class DiscountList {

    public static Discount checkDiscount(String code) {
        Discount discount = Discount.getDiscount();
        if(code.contentEquals("SHOP1")){
            discount.setCode("SHOP1");
            discount.setPrice(2000);
        }
        else if(code.contentEquals("SHOP2")){
            discount.setCode("SHOP2");
            discount.setPrice(3000);
        }else{
            discount.setCode("");
            discount.setPrice(0);
        }
        return discount;
    }

}
