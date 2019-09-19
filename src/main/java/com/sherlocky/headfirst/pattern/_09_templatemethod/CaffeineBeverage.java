package com.sherlocky.headfirst.pattern._09_templatemethod;

/**
 * 咖啡因饮料抽象类
 * <p>咖啡和茶都是含有咖啡因的饮料。</p>
 */
public abstract class CaffeineBeverage {
    /**
     * 模板方法，声明为final，防止子类覆盖（避免子类修改这个算法的顺序）
     * <p>该模板方法定义了一连串的步骤，每个步骤由一个方法代表。</p>
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        // 如果客户想加“调料”
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 这两个【抽象方法】必须由具体的子类实现
     */
    // 冲泡
    abstract void brew();

    // 添加调料
    abstract void addCondiments();

    /**
     * 声明为final，【具体方法】不希望子类覆盖的方法；
     * 可以被模板方法直接调用，或者被子类使用。
     */
    // 烧水
    final void boilWater() {
        System.out.println("烧水~~");
    }

    // 倒进杯子
    final void pourInCup() {
        System.out.println("倒进杯子~");
    }

    /**
     * 【钩子方法】默认不做事的方法，即“钩子”（hook）
     * <p>子类可以视情况决定要不要覆盖他们，如果不覆盖，抽象类会提供一个默认的实现。</p>
     *
     * <p>钩子是一种被声明在抽象类中的方法，但只有空的或者默认的实现。
     * 钩子的存在可以让子类有能力对算法的不同点进行挂钩。
     * 要不要挂钩由子类决定。</p>
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
