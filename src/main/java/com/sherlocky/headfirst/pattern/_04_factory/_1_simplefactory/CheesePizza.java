package com.sherlocky.headfirst.pattern._04_factory._1_simplefactory;

import com.sherlocky.headfirst.pattern._04_factory.Pizza;

/**
 * 奶酪披萨
 * <p>具体的披萨产品类，必须实现Pizza接口或者扩展抽象的Pizza类，并设计成一个具体的类。</p>
 */
public class CheesePizza extends Pizza {
	public CheesePizza() {
		name = "Cheese Pizza";
		dough = "Regular Crust";
		sauce = "Marinara Pizza Sauce";
		toppings.add("Fresh Mozzarella");
		toppings.add("Parmesan");
	}
}
