package com.sherlocky.headfirst.pattern._02_observer;

import java.util.ArrayList;

/**
 * @author: zhangcx
 * @date: 2018/12/23 15:11
 */
public class WeatherDataSubject implements Subject {
    // 记录所有的观察者(一对多)
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDataSubject() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.update(temperature, humidity, pressure));
    }

    /**
     * 当从气象站得到更新观测值是，我们通知观察者
     */
    public void measurementsChanged() {
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
}
