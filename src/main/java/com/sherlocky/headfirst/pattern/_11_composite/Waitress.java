package com.sherlocky.headfirst.pattern._11_composite;

import java.util.Iterator;

/**
 * 女服务员 类
 */
public class Waitress {
    /**
     * 只需要将最顶层的菜单组件交给她就可以了，最顶层的菜单包含其他所有菜单。
     */
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }

    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenus.createIterator();

        System.out.println("\n素食菜单\n----");
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                if (menuComponent.isVegetarian()) {
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException e) {
            }
        }
    }
}
