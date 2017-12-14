package com.kpl.sandwichshop.models.filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/6/2017.
 */

public class Pepper extends Filling {
    @Override
    public String getName() {
        return "Pepper";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.pepper;
    }

    @Override
    public String getCategory() {
        return StaticKeys.CATEGORY_CONDIMENT;
    }
}
