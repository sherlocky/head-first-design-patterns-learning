package com.sherlocky.headfirst.pattern._07_adapter;

/**
 * 给苹果手机充电
 * <p>
 *     以使用充电接口转换器给iphone充电为例，说明适配器模式
 * </p>
 *
 * 该示例，共出现四种角色：
 * <ul>
 *   <li>目标抽象类（Lightning接口）</li>
 *   <li>适配者类（安卓充电器）</li>
 *   <li>客户端（苹果手机）</li>
 *   <li>适配器（充电接口转换器）</li>
 * </ul>
 * @author: zhangcx
 * @date: 2019/9/8 17:22
 */
public class IphoneCharge {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidCharger();
        TypeC2LightningAdapter adapter = new TypeC2LightningAdapter(androidCharger);
        Iphone iphone = new Iphone();
        iphone.setLightningInterface(adapter);
        iphone.charge();
    }
}
