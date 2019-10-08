package com.sherlocky.headfirst.pattern._11_composite;

import java.util.Iterator;

/**
 * 菜单组件抽象类
 * <p>所有的组件都必须实现 MenuComponent 接口；
 * 然而叶节点和组合节点的角色不同，所以有些方法可能并不适合某种节点。</p>
 */
public abstract class MenuComponent {
    /** 提供了一系列默认实现 */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public abstract Iterator<MenuComponent> createIterator();

    public void print() {
        throw new UnsupportedOperationException();
    }
}
