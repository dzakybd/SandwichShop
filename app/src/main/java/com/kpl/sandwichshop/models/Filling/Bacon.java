package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Bacon extends Filling {
    @Override
    public String getName() { return "Bacon"; }

    @Override
    public int getPrice() { return 2000; }

    @Override
    public int getDrawable() { return 0; }

    @Override
    public String getCategory() {
        return StaticKeys.categoryMeat;
    }
}
