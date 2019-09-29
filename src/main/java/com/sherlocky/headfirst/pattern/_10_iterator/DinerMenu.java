package com.sherlocky.headfirst.pattern._10_iterator;

import java.util.Iterator;

/**
 * 主餐菜单
 */
public class DinerMenu implements Menu {
    static final int MAX_ITEMS = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];

        addItem("素食BLT",
                "（Fakin'）全麦培根莴苣和番茄", true, 2.99);
        addItem("BLT",
                "培根配生菜和番茄全麦", false, 2.99);
        addItem("今日例汤",
                "今日例汤, 配以土豆沙拉", false, 3.29);
        addItem("热狗",
                "热狗，配酸菜，调味，洋葱和奶酪",
                false, 3.05);
        addItem("糙米蒸蔬菜",
                "糙米蒸蔬菜", true, 3.99);
        addItem("意大利面食",
                "意大利面配Marinara酱和一片酸面包",
                true, 3.89);
    }

    public void addItem(String name, String description,
                        boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEMS) {
            System.err.println("抱歉，菜单已满！无法将项目添加到菜单。");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    /**
     * 菜单类负责提供适当的具体菜单迭代器
     * @return
     */
    @Override
    public Iterator<MenuItem> createIterator() {
        return new DinerMenuIterator(menuItems);
    }
    // other menu methods here
}
