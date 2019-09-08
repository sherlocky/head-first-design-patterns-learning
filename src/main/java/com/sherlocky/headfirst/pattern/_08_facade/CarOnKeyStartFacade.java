package com.sherlocky.headfirst.pattern._08_facade;
/**
 * 汽车一键启动（门面）类 -- 门面/外观角色
 *
 * <p>一键启动简化了 之前的插钥匙、通电、发动的复杂步骤，可以做到一键发动、一键熄火。</p>
 *
 * @author: zhangcx
 * @date: 2019/9/8 18:15
 */
public class CarOnKeyStartFacade {
    private CarPower power;
    private CarEngine engine;
    private CarKey key;

    public CarOnKeyStartFacade() {
        this.key = new CarKey();
        this.power = new CarPower();
        this.engine = new CarEngine();
    }

    /**
     * 一键发动汽车
     */
    public void start() {
        System.out.println("发动汽车~~");
        // 其实，一键启动是不需要插入钥匙的，此处为了方便作为示例
        key.insert();
        power.turnOnPower();
        engine.startEngine();
    }

    /**
     * 一键熄火
     */
    public void stop() {
        System.out.println("熄火~");
        engine.turnOffEngine();
        power.turnOffPower();
        key.pullOut();
    }
}
