package com.sherlocky.headfirst.pattern._10_iterator;

public class MenuTestDrive {
    public static void main(String args[]) {
        PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
        DinerMenu dinerMenu = new DinerMenu();
        Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
        waitress.printMenu();
        waitress.printVegetarianMenu();

        System.out.println("\n顾客问: 热狗是素食吗？");
        System.out.print("女服务员说: ");
        System.out.println(waitress.isItemVegetarian("热狗") ? "是" : "不是");

        System.out.println("\n顾客问: 威化饼是素食吗?");
        System.out.print("女服务员说: ");
        System.out.println(waitress.isItemVegetarian("威化饼") ? "是" : "不是");
    }
}
