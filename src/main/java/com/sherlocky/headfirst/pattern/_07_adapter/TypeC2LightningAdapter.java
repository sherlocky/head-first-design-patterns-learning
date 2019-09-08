package com.sherlocky.headfirst.pattern._07_adapter;

/**
 * 安卓type-c和苹果lightning转换适配器
 * <p>
 *     该适配器实现了LightningInterface，并组合了TypeCInterface，
 *     当外部调用chargeWithLightning方法的时候，实际上调用的是typeCInterface.chargeWithTypeC方法。
 * </p>
 * <p>
 *     就像电源适配器，他实现的是一个Lightning的规范，自身是一个Lightning的插头，
 *     但实际充电的时候，他是通过typc-c的电源进行的，他起到的是一个中间转换的作用。
 * </p>
 * @author: zhangcx
 * @date: 2019/9/8 17:15
 */
public class TypeC2LightningAdapter implements LightningInterface {
    private TypeCInterface typeCInterface;

    public TypeC2LightningAdapter(TypeCInterface typeCInterface) {
        this.typeCInterface = typeCInterface;
    }

    @Override
    public void chargeWithLightning() {
        typeCInterface.chargeWithTypeC();
    }
}
