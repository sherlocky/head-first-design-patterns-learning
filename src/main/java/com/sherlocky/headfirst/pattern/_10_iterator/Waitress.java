package com.sherlocky.headfirst.pattern._10_iterator;

import java.util.Iterator;

/**
 * 女服务员 类
 * <p>煎饼屋和正餐菜单的类都实现了{@link Menu}接口，
 * 女服务员可以利用接口（而不是具体的类）引用每一个菜单对象。</p>
 *
 * <p>这样，通过“针对接口编程，而不针对实现编程”，
 * 我们就可以减少女服务员和具体菜单类之间的依赖。</p>
 *
 * <p>现在，女服务员只需要关心菜单和迭代器这两个接口</p>
 */
public class Waitress {
    Menu pancakeHouseMenu;
    Menu dinerMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
    }

    /**
     * 打印菜单
     */
    public void printMenu() {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();

        System.out.println("菜单\n----\n早餐");
        printMenu(pancakeIterator);
        System.out.println("\n正餐");
        printMenu(dinerIterator);
    }

    /**
     * 服务员已经从具体的菜单类解耦了，现在可以利用迭代器来遍历菜单项。
     * 而无需知道菜单项列表是如何被实现的。
     * @param iterator
     */
    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.print(menuItem.getName() + ", ");
            System.out.print(menuItem.getPrice() + " -- ");
            System.out.println(menuItem.getDescription());
        }
    }

    /**
     * 打印素食菜单
     */
    public void printVegetarianMenu() {
        System.out.println("\n素食菜单\n----\n早餐");
        printVegetarianMenu(pancakeHouseMenu.createIterator());
        System.out.println("\n正餐");
        printVegetarianMenu(dinerMenu.createIterator());
    }

    public boolean isItemVegetarian(String name) {
        Iterator<MenuItem> pancakeIterator = pancakeHouseMenu.createIterator();
        if (isVegetarian(name, pancakeIterator)) {
            return true;
        }
        Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
        if (isVegetarian(name, dinerIterator)) {
            return true;
        }
        return false;
    }


    private void printVegetarianMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.isVegetarian()) {
                System.out.print(menuItem.getName());
                System.out.println("\t\t" + menuItem.getPrice());
                System.out.println("\t" + menuItem.getDescription());
            }
        }
    }

    private boolean isVegetarian(String name, Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.getName().equals(name)) {
                if (menuItem.isVegetarian()) {
                    return true;
                }
            }
        }
        return false;
    }
}
