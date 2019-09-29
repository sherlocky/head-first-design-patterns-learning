package com.sherlocky.headfirst.pattern._10_iterator;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋菜单 类
 */
public class PancakeHouseMenu implements Menu {
    ArrayList<MenuItem> menuItems;

    public PancakeHouseMenu() {
        menuItems = new ArrayList<MenuItem>();

        addItem("K＆B的煎饼早餐",
                "煎饼配炒鸡蛋和烤面包",
                true,
                2.99);

        addItem("常规煎饼早餐",
                "煎饼配煎蛋，香肠",
                false,
                2.99);

        addItem("蓝莓煎饼",
                "用新鲜蓝莓和蓝莓糖浆制成的煎饼",
                true,
                3.49);

        addItem("威化饼",
                "威化饼，您可以选择蓝莓或草莓",
                true,
                3.59);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public ArrayList<MenuItem> getMenuItems() {
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> createIterator() {
		// 直接调用菜单项 ArrayList 的迭代器
        return menuItems.iterator();
    }

    // other menu methods here
}
