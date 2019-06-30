package com.sherlocky.headfirst.pattern._04_factory._1_simplefactory;

import com.sherlocky.headfirst.pattern._04_factory.pizza.Pizza;
import com.sherlocky.headfirst.pattern._04_factory.pizza._1_simplefactory.PizzaStore;
import com.sherlocky.headfirst.pattern._04_factory.pizza._1_simplefactory.SimplePizzaFactory;

/**
 * {@link SimplePizzaFactory}
 */
public class PizzaTestDrive {

    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);

        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);
    }
}
