package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.R;
import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/6/2017.
 */

public class Garlic extends Filling {
    @Override
    public String getName() { return "Garlic"; }

    @Override
    public int getPrice() { return 500; }

    @Override
    public int getDrawable() { return R.drawable.garlic; }

    @Override
    public String getCategory() {
        return StaticKeys.categoryVegetable;
    }
}
