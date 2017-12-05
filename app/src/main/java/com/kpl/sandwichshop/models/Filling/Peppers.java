package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;

/**
 * Created by Hendry on 12/5/2017.
 */

public class Peppers extends Filling{
    @Override
    public String getName() { return "Peppers"; }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return 0;
    }

    @Override
    public String getCategory() {
        return StaticKeys.categoryVegetable;
    }
}
