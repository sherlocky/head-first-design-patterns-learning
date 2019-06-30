package com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.pizza;

import com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.factory.PizzaIngredientFactory;

public class PepperoniPizza extends AbstractPizza {
    PizzaIngredientFactory ingredientFactory;

    public PepperoniPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        veggies = ingredientFactory.createVeggies();
        pepperoni = ingredientFactory.createPepperoni();
    }
}
