package com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory;

import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.pizza.AbstractPizza;

/**
 * 抽象Pizza商店类
 */
public abstract class AbstractPizzaStore {

    protected abstract AbstractPizza createPizza(String item);

    public AbstractPizza orderPizza(String type) {
        AbstractPizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
