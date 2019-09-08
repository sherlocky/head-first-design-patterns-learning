package com.sherlocky.headfirst.pattern._08_facade;

/**
 * 门面模式主要包含3种角色：
 * <p>
 * - 客户端角色：调用者<br/>
 * - 外观角色（Facade）：也称 门面角色，系统对外的统一接口；<br/>
 * - 子系统角色（SubSystem）：可以同时有一个或多个 SubSystem。<br/>
 *
 *   每个 SubSytem 都不是一个单独的类，而是一个类的集合。<br/>
 *   SubSystem 并不知道 Facade 的存在，对于 SubSystem 而言，
 *   Facade 只是另一个客户端而已（即 Facade 对 SubSystem 透明）。
 * </p>
 * @author: zhangcx
 * @date: 2019/9/8 21:53
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("###### 普通汽车启动/熄火");
        drivingCar();
        System.out.println("###### 带一键启动功能的汽车启动/熄火");
        dringCarByOnKeyStart();
    }

    /**
     * 普通汽车启动/熄火
     */
    private static void drivingCar() {
        CarPower power = new CarPower();
        CarEngine engine = new CarEngine();
        CarKey key = new CarKey();
        System.out.println("发动汽车~~");
        key.insert();
        power.turnOnPower();
        engine.startEngine();

        System.out.println("熄火~");
        engine.turnOffEngine();
        power.turnOffPower();
        key.pullOut();
    }

    /**
     * 带一键启动功能的汽车启动/熄火
     */
    private static void dringCarByOnKeyStart() {
        /**
         * 该方法中子系统(钥匙、电源、发动机)代码不变，
         * 然后增加了一个外观/门面类 CarOnKeyStartFacade，
         * 最终客户（Driver）的调用方式就精简许多
         */
        // 使用门面模式下：司机驾驶汽车
        CarOnKeyStartFacade carOnKeyStart = new CarOnKeyStartFacade();
        carOnKeyStart.start();
        carOnKeyStart.stop();
    }
}
