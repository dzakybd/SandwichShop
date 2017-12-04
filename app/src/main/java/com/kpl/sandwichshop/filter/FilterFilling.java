package com.kpl.sandwichshop.filter;

import com.kpl.sandwichshop.models.Filling.Filling;

import java.util.List;

/**
 * Created by zaki on 4/12/17.
 */

public interface FilterFilling {
    List<Filling> meetCriteria(List<Filling> fillings);
}
