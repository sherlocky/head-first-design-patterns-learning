package com.sherlocky.headfirst.pattern._04_factory.pizza._1_simplefactory;

import com.sherlocky.headfirst.pattern._04_factory.pizza.Pizza;

/**
 * 意大利肠披萨
 */
public class PepperoniPizza extends Pizza {
	public PepperoniPizza() {
		name = "Pepperoni Pizza";
		dough = "Crust";
		sauce = "Marinara sauce";
		toppings.add("Sliced Pepperoni");
		toppings.add("Sliced Onion");
		toppings.add("Grated parmesan cheese");
	}
}
