package com.sherlocky.headfirst.pattern._04_factory.pizza._1_simplefactory;

import com.sherlocky.headfirst.pattern._04_factory.pizza.Pizza;

/**
 * 蛤蜊披萨
 */
public class ClamPizza extends Pizza {
	public ClamPizza() {
		name = "Clam Pizza";
		dough = "Thin crust";
		sauce = "White garlic sauce";
		toppings.add("Clams");
		toppings.add("Grated parmesan cheese");
	}
}
