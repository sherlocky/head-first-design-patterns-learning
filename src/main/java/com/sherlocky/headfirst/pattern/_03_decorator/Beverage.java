package com.sherlocky.headfirst.pattern._03_decorator;

/**
 * 抽象饮料类——亦即本例中被装饰者类
 * <p>以星巴兹咖啡为例分析装饰者模式</p>
 * @author: zhangcx
 * @date: 2018/12/26 21:16
 */
public abstract class Beverage {
    public enum Size { TALL, GRANDE, VENTI };
    // 饮料分小杯、中杯、大杯，饮料本身以及调料都会根据不同的杯型分别定价
    Size size = Size.TALL; // 默认小杯
    String description = "Unknow Beverage";

    public String getDescription() {
        return getSizeLabel() + description;
    }

    // 价格计算（应该在子类中覆盖实现）
    public abstract double cost();

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return this.size;
    }

    private String getSizeLabel() {
        return "(" + (getSize() == Size.TALL ? "小杯" : (getSize() == Size.GRANDE ? "中杯" : "大杯")) + ")";
    }
}
