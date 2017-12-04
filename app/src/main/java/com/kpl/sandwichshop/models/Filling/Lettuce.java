package com.kpl.sandwichshop.models.Filling;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.R;

/**
 * Created by zaki on 4/12/17.
 */

public class Lettuce extends Filling {
    @Override
    public String getName() {
        return "Lettuce";
    }

    @Override
    public int getPrice() {
        return 500;
    }

    @Override
    public int getDrawable() {
        return R.drawable.selada;
    }

    @Override
    public String getCategory() {
        return StaticKeys.categoryVegetable;
    }
}
