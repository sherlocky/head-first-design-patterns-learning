package com.sherlocky.headfirst.pattern._09_templatemethod;

/**
 * 饮料制作测试
 * @author: zhangcx
 * @date: 2019/9/19 18:39
 */
public class BeverageTest {
    public static void main(String[] args) {
        TeaWithHook tea = new TeaWithHook();

        CoffeeWithHook coffee = new CoffeeWithHook();

        System.out.println("## 制作茶--");
        tea.prepareRecipe();
        System.out.println("$$ 茶做好了--");

        System.out.println("## 制作咖啡--");
        coffee.prepareRecipe();
        System.out.println("$$ 咖啡做好了--");
    }
}
