package com.sherlocky.headfirst.pattern._11_composite;

/**
 *
 */
public class MenuTestDrive {
    public static void main(String args[]) {

        MenuComponent pancakeHouseMenu =
                new Menu("煎饼屋菜单", "早餐");
        MenuComponent dinerMenu =
                new Menu("主餐厅菜单", "午餐");
        MenuComponent cafeMenu =
                new Menu("咖啡厅菜单", "晚餐");
        MenuComponent dessertMenu =
                new Menu("甜点菜单", "必须有甜点!");

        MenuComponent allMenus = new Menu("所有菜单", "所有菜单合集");

        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        pancakeHouseMenu.add(new MenuItem(
                "K＆B的煎饼早餐",
                "煎饼配炒鸡蛋和烤面包",
                true,
                2.99));
        pancakeHouseMenu.add(new MenuItem(
                "常规煎饼早餐",
                "煎饼配煎蛋，香肠",
                false,
                2.99));
        pancakeHouseMenu.add(new MenuItem(
                "蓝莓煎饼",
                "用新鲜蓝莓和蓝莓糖浆制成的煎饼",
                true,
                3.49));
        pancakeHouseMenu.add(new MenuItem(
                "威化饼",
                "威化饼，您可以选择蓝莓或草莓",
                true,
                3.59));

        dinerMenu.add(new MenuItem(
                "素食BLT",
                "（Fakin'）全麦培根莴苣和番茄",
                true,
                2.99));
        dinerMenu.add(new MenuItem(
                "BLT",
                "培根配生菜和番茄全麦",
                false,
                2.99));
        dinerMenu.add(new MenuItem(
                "今日例汤",
                "今日例汤, 配以土豆沙拉",
                false,
                3.29));
        dinerMenu.add(new MenuItem(
                "热狗",
                "热狗，配酸菜，调味，洋葱和奶酪",
                false,
                3.05));
        dinerMenu.add(new MenuItem(
                "糙米蒸蔬菜",
                "糙米蒸蔬菜",
                true,
                3.99));

        dinerMenu.add(new MenuItem(
                "意大利面食",
                "意大利面配Marinara酱和一片酸面包",
                true,
                3.89));

        dinerMenu.add(dessertMenu);

        dessertMenu.add(new MenuItem(
                "苹果派",
                "香草冰淇淋味苹果派，酥皮",
                true,
                1.59));
        dessertMenu.add(new MenuItem(
                "乳酪蛋糕",
                "纽约奶油芝士蛋糕，配以巧克力全麦面包皮",
                true,
                1.99));
        dessertMenu.add(new MenuItem(
                "冰糕",
                "一勺覆盆子和一勺石灰",
                true,
                1.89));

        cafeMenu.add(new MenuItem(
                "素汉堡和炸薯条",
                "全麦面包，生菜，番茄和薯条上的素食汉堡",
                true,
                3.99));
        cafeMenu.add(new MenuItem(
                "今日例汤",
                "今日例汤, 配以沙拉",
                false,
                3.69));
        cafeMenu.add(new MenuItem(
                "墨西哥卷饼",
                "大墨西哥卷饼，配整个斑豆，莎莎酱，鳄梨调味酱",
                true,
                4.29));

        Waitress waitress = new Waitress(allMenus);
        //waitress.printMenu();
        waitress.printVegetarianMenu();
    }
}