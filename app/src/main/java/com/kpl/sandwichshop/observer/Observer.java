package com.kpl.sandwichshop.observer;

import com.kpl.sandwichshop.Order;

/**
 * Created by Hendry on 12/5/2017.
 */

public interface Observer {
    void update(Order order);

}
