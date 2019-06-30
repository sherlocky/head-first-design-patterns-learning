package com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.pizza;

import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.factory.PizzaIngredientFactory;

public class VeggiePizza extends AbstractPizza {
    PizzaIngredientFactory ingredientFactory;

    public VeggiePizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
    }
}
