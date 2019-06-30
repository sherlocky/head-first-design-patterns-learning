package com.sherlocky.headfirst.pattern._04_factory._2_factorymethod;

import com.sherlocky.headfirst.pattern._04_factory._1_simplefactory.Pizza;

public class NYStyleClamPizza extends Pizza {

    public NYStyleClamPizza() {
        name = "NY Style Clam Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
        toppings.add("Fresh Clams from Long Island Sound");
    }
}
