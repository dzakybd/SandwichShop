package com.kpl.sandwichshop.filter;

import com.kpl.sandwichshop.StaticKeys;
import com.kpl.sandwichshop.models.Filling.Filling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public class VegetableFilter implements FilterFilling {
    @Override
    public List<Filling> meetCriteria(List<Filling> fillings) {
        List<Filling> vegetable = new ArrayList<>();
        for (Filling filling : fillings) {
            if (filling.getCategory().contentEquals(StaticKeys.categoryVegetable)) {
                vegetable.add(filling);
            }
        }
        return vegetable;
    }
}

