package com.sherlocky.headfirst.pattern._02_observer.use_java_api;

import java.util.Observable;

/**
 * Java API 已经内置了观察者模式，在 java.util 包含最基本的 Observer 接口与 Observable 类，这和我们自行实现的 Observer 接口和 Subjec 接口很相似，Observer接口和Observable类在使用上更方便，因为许多功能都已经事先准备好了。
 * <p>甚至可以使用推（push）或拉（pull）的方式传送数据</p>
 *
 * @author: zhangcx
 * @date: 2018/12/23 16:31
 */
public class WeatherData extends Observable {
    /* 温度 */
    private float temperature;
    /* 湿度 */
    private float humidity;
    /* 气压 */
    private float pressure;

    // 不需要自行实现注册、取消注册、通知观察者等方法，超类中已经提供了默认的实现

    public WeatherData() {
    }

    /**
     * 当从气象站得到更新观测值是，我们通知观察者
     */
    public void measurementsChanged() {
        /**
         * setChanged() 方法用来标记状态已经改变的事实，好让 notifyObservers()
         * 知道当他被调用时应该更新观察者。如果调用 notifyObservers()之前
         * 没有先调用 setChanged()方法，观察者就”不会“被通知。
         *
         * 此外还提供了 clearChanged(), hasChanged() 等方法。
         */
        setChanged(); // 必需
        notifyObservers();
    }

    /**
     * FixMe:
     * 暂时使用这个方法来模拟气象数据更新，以测试布告板（可以从网站上抓取真实的观测值）
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }


    /** getter() 方法s方便观察者主动拉取（自行实现的只支持推） */
    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
