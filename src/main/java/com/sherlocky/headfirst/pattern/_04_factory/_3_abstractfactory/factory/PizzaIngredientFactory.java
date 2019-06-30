package com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.factory;

import com.sherlocky.headfirst.pattern._04_factory._3_abstractfactory.ingredient.*;
import com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.ingredient.*;

/**
 * 抽象工厂--Pizza 原料抽象工厂
 */
public interface PizzaIngredientFactory {

    public Dough createDough();

    public Sauce createSauce();

    public Cheese createCheese();

    public Veggies[] createVeggies();

    public Pepperoni createPepperoni();

    public Clams createClam();

}
