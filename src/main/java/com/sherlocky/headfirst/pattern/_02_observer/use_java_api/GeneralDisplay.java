package com.sherlocky.headfirst.pattern._02_observer.use_java_api;

import com.sherlocky.headfirst.pattern._02_observer.DisplayElement;

import java.util.Observable;
import java.util.Observer;

/**
 * 实现 Java API 提供的 Observer 接口
 * @author: zhangcx
 * @date: 2018/12/23 16:36
 */
public class GeneralDisplay implements Observer, DisplayElement {
    Observable obs;
    private float temperature;
    private float humidity;
    private float pressure;

    public GeneralDisplay(Observable obs) {
        this.obs = obs;
        obs.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData wd = (WeatherData) o;
            this.temperature = wd.getTemperature();
            this.humidity = wd.getHumidity();
            this.pressure = wd.getPressure();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("General（use Java API）: " + temperature + "°（摄氏度） and " + humidity + "%（湿度） humidity and " + pressure + "hPa（百帕）");
    }
}
