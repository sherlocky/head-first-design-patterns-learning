package com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.pizza;

import com.sherlocky.headfirst.pattern._04_factory.pizza._3_abstractfactory.factory.PizzaIngredientFactory;

/**
 * 具体的产品类--芝士披萨
 */
public class CheesePizza extends AbstractPizza {
    PizzaIngredientFactory ingredientFactory;

    /**
     * 要制作比萨需要工厂提供原料。
     * 每个比萨类都需要从构造函数参数中得到一个工厂，并存储到一个实例变量中。
     *
     * 这样，Pizza 和区域原料之间被解耦。
     * @param ingredientFactory
     */
    public CheesePizza(PizzaIngredientFactory ingredientFactory) {
        /**
         * 比萨不在乎使用了什么工厂，只要是原料工厂就行。
         */
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
