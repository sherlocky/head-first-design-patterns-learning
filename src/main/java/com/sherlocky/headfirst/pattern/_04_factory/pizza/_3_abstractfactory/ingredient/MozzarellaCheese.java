package com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.ingredient;

import com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.ingredient.Cheese;

public class MozzarellaCheese implements Cheese {

    @Override
    public String toString() {
        return "Shredded Mozzarella";
    }
}
