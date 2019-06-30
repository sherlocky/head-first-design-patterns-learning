package com.sherlocky.headfirst.pattern._04_factory._1_simplefactory;

/**
 * 简单工厂的“客户”，PizzaStore通过SimplePizzaFactory取得披萨的实例。
 * @author: zhangcx
 * @date: 2019/6/30 10:37
 */
public class PizzaStore {
    SimplePizzaFactory factory;

    /**
     * 构造器需要一个 SimplePizzaFactory 参数
     * @param factory
     */
    public PizzaStore(SimplePizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza;

        pizza = factory.createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }
}
