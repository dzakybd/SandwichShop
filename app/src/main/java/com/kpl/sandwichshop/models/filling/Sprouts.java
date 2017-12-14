package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Sprouts extends Filling {
    @Override
    public String getName() {
        return "Sprouts";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return 0;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_VEGETABLE;
    }
}
