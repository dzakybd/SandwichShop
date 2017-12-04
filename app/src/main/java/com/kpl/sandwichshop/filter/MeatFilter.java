package com.kpl.sandwichshop.filter;

import com.kpl.sandwichshop.FillingCategory;
import com.kpl.sandwichshop.models.Filling.Filling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public class MeatFilter implements FilterFilling {
    @Override
    public List<Filling> meetCriteria(List<Filling> fillings) {
        List<Filling> meat = new ArrayList<>();
        for (Filling filling : fillings) {
            if (filling.getCategory().contentEquals(FillingCategory.meat)) {
                meat.add(filling);
            }
        }
        return meat;
    }
}

