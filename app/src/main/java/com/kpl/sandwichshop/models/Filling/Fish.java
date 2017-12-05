package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Fish extends Filling {
    @Override
    public String getName() { return "Fish"; }

    @Override
    public int getPrice() { return 1000; }

    @Override
    public int getDrawable() { return R.drawable.ikan; }

    @Override
    public String getCategory() {
        return StaticKeys.categoryMeat;
    }
}
