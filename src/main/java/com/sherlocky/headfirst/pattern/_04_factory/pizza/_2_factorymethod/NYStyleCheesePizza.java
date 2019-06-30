package com.sherlocky.headfirst.pattern._04_factory.pizza._2_factorymethod;

import com.sherlocky.headfirst.pattern._04_factory.pizza.Pizza;

public class NYStyleCheesePizza extends Pizza {

    public NYStyleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
