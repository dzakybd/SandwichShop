package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Egg extends Filling {
    @Override
    public String getName() {
        return "Egg";
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public int getDrawable() {
        return R.drawable.egg;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_MEAT;
    }
}
