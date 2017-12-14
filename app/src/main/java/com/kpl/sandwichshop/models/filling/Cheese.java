package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by zaki on 4/12/17.
 */

public class Cheese extends Filling {
    @Override
    public String getName() {
        return "Cheese";
    }

    @Override
    public int getPrice() {
        return 1500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.cheese;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_CONDIMENT;
    }
}
