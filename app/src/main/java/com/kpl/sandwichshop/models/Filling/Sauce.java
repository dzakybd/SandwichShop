package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/6/2017.
 */

public class Sauce extends Filling {
    @Override
    public String getName() {
        return "Sauce";
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public int getDrawable() {
        return R.drawable.sauce;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_CONDIMENT;
    }
}
