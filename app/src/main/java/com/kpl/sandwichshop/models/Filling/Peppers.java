package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Peppers extends Filling {
    @Override
    public String getName() {
        return "Peppers";
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public int getDrawable() {
        return R.drawable.peppers;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_VEGETABLE;
    }
}
