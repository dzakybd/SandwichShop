package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by zaki on 4/12/17.
 */

public class Chicken extends Filling {
    @Override
    public String getName() {
        return "Chicken meat";
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.chicken;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_MEAT;
    }
}
