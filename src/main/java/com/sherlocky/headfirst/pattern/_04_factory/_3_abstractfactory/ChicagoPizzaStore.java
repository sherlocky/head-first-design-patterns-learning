package com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory;

import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.factory.ChicagoPizzaIngredientFactory;
import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.factory.PizzaIngredientFactory;
import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.pizza.*;

public class ChicagoPizzaStore extends AbstractPizzaStore {

    @Override
    protected AbstractPizza createPizza(String item) {
        AbstractPizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();

        if (item.equals("cheese")) {

            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("Chicago Style Cheese Pizza");

        } else if (item.equals("veggie")) {

            pizza = new VeggiePizza(ingredientFactory);
            pizza.setName("Chicago Style Veggie Pizza");

        } else if (item.equals("clam")) {

            pizza = new ClamPizza(ingredientFactory);
            pizza.setName("Chicago Style Clam Pizza");

        } else if (item.equals("pepperoni")) {

            pizza = new PepperoniPizza(ingredientFactory);
            pizza.setName("Chicago Style Pepperoni Pizza");

        }
        return pizza;
    }
}
