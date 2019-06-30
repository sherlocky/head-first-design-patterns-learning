package com.sherlocky.headfirst.pattern._04_factory._2_factorymethod;

import com.sherlocky.headfirst.pattern._04_factory._1_simplefactory.Pizza;

/**
 * 抽象 PizzaStore类，因为规模扩大后可以有很多不同区域的加盟店。
 * <p>在简单工厂中是由一个对象负责所有的具体类的实例化，
 * 现在通过对PizzaStore做一些小改变，变成由一群子类来负责实例化</p>
 *
 * <p>工厂方法模式：</p>
 * <p>定义了一个创建对象的接口，但由子类决定要实例化的类是哪一个。工厂方法让类把实例化推迟到子类。</p>
 *
 * <p>本类即为创建者，创建者不需要真的知道在制造哪种具体的产品。</p>
 *
 * <p>工厂方法模式并不是允许子类本身在运行时做决定，而是指在编写创建者类时，不需要知道实际创建的产品是哪一个。
 * 选择使用哪个子类，自然就决定了实际创建的产品是什么。</p>
 *
 * <p>可以定义一个默认的工厂方法来产生某些具体的产品，这么一来，
 * 即使创建者没有任何子类，依然可以创建产品。</p>
 *
 * @author: zhangcx
 * @date: 2019/6/30 10:55
 */
public abstract class AbstractPizzaStore {
    /**
     * 【工厂方法】的依赖倒置
     * AbstractPizzaStore ”依赖于“ Pizza 这个抽象类。
     * 具体的披萨类也依赖Pizza抽象，因为他们实现了Pizza的接口(广义)。
     *
     * 即：高层组件（AbstractPizzaStore）和低层组件（具体的Pizza类）都依赖了Pizza抽象。
     */

    /**
     * 【工厂方法】
     * 实例化pizza的责任被移到一个“方法”中，此方法如同是一个“工厂”。
     * - 工厂方法是抽象的，依赖子类来处理对象的创建。
     * - 工厂方法必须返回一个产品。
     * - 工厂方法将客户（也就是超类中的其他方法）和实例创建具体产品的代码分隔开来。
     *
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);

    /**
     * PizzaStore的子类在 createPizza 方法中处理Pizza对象的实例化。
     * @param type
     * @return
     */
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println("--- Making a " + pizza.getName() + " ---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
