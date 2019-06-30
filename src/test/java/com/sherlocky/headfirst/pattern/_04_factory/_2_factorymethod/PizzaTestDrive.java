package com.sherlocky.headfirst.pattern._04_factory._2_factorymethod;

import com.sherlocky.headfirst.pattern._04_factory.pizza.Pizza;
import com.sherlocky.headfirst.pattern._04_factory.pizza._2_factorymethod.AbstractPizzaStore;
import com.sherlocky.headfirst.pattern._04_factory.pizza._2_factorymethod.ChicagoPizzaStore;
import com.sherlocky.headfirst.pattern._04_factory.pizza._2_factorymethod.NYPizzaStore;

/**
 * {@link AbstractPizzaStore}
 * {@link NYPizzaStore}
 * {@link ChicagoPizzaStore}
 */
public class PizzaTestDrive {

    public static void main(String[] args) {
        AbstractPizzaStore nyStore = new NYPizzaStore();
        AbstractPizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = nyStore.orderPizza("clam");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("clam");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = nyStore.orderPizza("pepperoni");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");

        pizza = nyStore.orderPizza("veggie");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("veggie");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
