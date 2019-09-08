package com.sherlocky.headfirst.pattern._07_adapter;

/**
 * 苹果手机类
 * @author: zhangcx
 * @date: 2019/9/8 17:10
 */
public class Iphone {
    private LightningInterface lightningInterface;

    public Iphone() {
    }

    // 充电方法
    public void charge() {
        if (lightningInterface == null) {
            System.out.println("未插入充电插头！");
            return;
        }
        System.out.println("开始给苹果手机充电~");
        lightningInterface.chargeWithLightning();
        System.out.println("苹果手机充电结束！");
    }

    public LightningInterface getLightningInterface() {
        return lightningInterface;
    }

    public void setLightningInterface(LightningInterface lightningInterface) {
        this.lightningInterface = lightningInterface;
    }
}
