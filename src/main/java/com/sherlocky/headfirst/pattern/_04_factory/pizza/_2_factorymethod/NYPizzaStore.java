package com.sherlocky.headfirst.pattern._04_factory.pizza._2_factorymethod;

import com.sherlocky.headfirst.pattern._04_factory.pizza.Pizza;

/**
 * 纽约Pizza加盟店
 */
public class NYPizzaStore extends AbstractPizzaStore {

    @Override
    public Pizza createPizza(String item) {
        if (item.equals("cheese")) {
            return new NYStyleCheesePizza();
        } else if (item.equals("veggie")) {
            return new NYStyleVeggiePizza();
        } else if (item.equals("clam")) {
            return new NYStyleClamPizza();
        } else if (item.equals("pepperoni")) {
            return new NYStylePepperoniPizza();
        } else {
            return null;
        }
    }
}
