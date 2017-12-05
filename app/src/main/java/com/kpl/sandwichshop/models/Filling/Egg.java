package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Egg extends Filling {
    @Override
    public String getName() { return "Egg"; }

    @Override
    public int getPrice() { return 1000; }

    @Override
    public int getDrawable() { return R.drawable.telur; }

    @Override
    public String getCategory() {
        return StaticKeys.categoryMeat;
    }
}
