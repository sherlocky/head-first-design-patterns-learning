package com.sherlocky.headfirst.pattern._04_factory._1_simplefactory;

/**
 * <p>简单披萨工厂</p>
 *
 * <p>简单工厂其实不是一个设计模式，反而比较像是一种编程习惯。</p>
 *
 * @author: zhangcx
 * @date: 2019/6/30 10:33
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type) {
        Pizza pizza = null;

        if (type.equals("cheese")) {
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")) {
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new ClamPizza();
        } else if (type.equals("veggie")) {
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
