package com.sherlocky.headfirst.pattern._04_factory.pizza;

import java.util.ArrayList;

/**
 * 把Pizza定义为抽象类，具有一些有用的实现，这些实现可以被覆盖。
 * <p>产品类</p>
 *
 * @author: zhangcx
 * @date: 2019/6/30 10:23
 */
public abstract class Pizza {
    /** Pizza 名称 */
    protected String name;
    /** 生面团 */
    protected String dough;
    /** 调味汁 */
    protected String sauce;
    /** 配料 */
    protected ArrayList<String> toppings = new ArrayList<String>();

    /**
     * 准备
     */
    public void prepare() {
        System.out.println("Prepare " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        System.out.println("Adding toppings: ");
        for (String topping : toppings) {
            System.out.println("   " + topping);
        }
    }

    /**
     * 烘焙
     */
    public void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }

    /**
     * 切片
     */
    public void cut() {
        System.out.println("Cut the pizza into diagonal slices");
    }

    /**
     * 装盒
     */
    public void box() {
        System.out.println("Place pizza in official AbstractPizzaStore box");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(dough + "\n");
        display.append(sauce + "\n");
        for (String topping : toppings) {
            display.append(topping + "\n");
        }
        return display.toString();
    }
}
