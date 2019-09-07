package com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory;

import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.factory.NYPizzaIngredientFactory;
import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.factory.PizzaIngredientFactory;
import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.pizza.*;

public class NYPizzaStore extends AbstractPizzaStore {

    @Override
    protected AbstractPizza createPizza(String item) {
        AbstractPizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("New York Style Clam Pizza");

        } else if (item.equals("pepperoni")) {

            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("New York Style Pepperoni Pizza");

        }
        return pizza;
    }
}
