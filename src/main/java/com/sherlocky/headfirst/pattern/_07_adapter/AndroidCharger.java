package com.sherlocky.headfirst.pattern._07_adapter;

/**
 * 安卓设备的充电器
 * @author: zhangcx
 * @date: 2019/9/8 17:12
 */
public class AndroidCharger implements TypeCInterface {
    @Override
    public void chargeWithTypeC() {
        System.out.println("使用Type-C型号的充电器充电。。。");
    }
}
