package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

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
        return R.drawable.ayam;
    }

    @Override
    public String getCategory() {
        return StaticKeys.categoryMeat;
    }
}
