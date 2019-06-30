package com.sherlocky.headfirst.pattern._04_factory._1_simplefactory;

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
