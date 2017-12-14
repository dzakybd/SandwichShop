package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/6/2017.
 */

public class Turkeys extends Filling {
    @Override
    public String getName() {
        return "Turkeys";
    }

    @Override
    public int getPrice() {
        return 2500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.turkeys;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_MEAT;
    }
}
