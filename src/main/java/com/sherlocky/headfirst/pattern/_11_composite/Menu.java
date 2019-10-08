package com.sherlocky.headfirst.pattern._11_composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 菜单节点 -- 组合节点
 */
public class Menu extends MenuComponent {
    Iterator<MenuComponent> iterator = null;
    /** 菜单可以有任意数目的孩子，这些孩子必须属于 MenuComponent 类型。 */
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Iterator<MenuComponent> createIterator() {
        if (iterator == null) {
            iterator = new CompositeIterator(menuComponents.iterator());
        }
        return iterator;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        Iterator<MenuComponent> iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            // 菜单和菜单项都实现了 print()，只需要调用各个组件的 print() 方法即可
            MenuComponent menuComponent = iterator.next();
            menuComponent.print();
        }
    }
}
