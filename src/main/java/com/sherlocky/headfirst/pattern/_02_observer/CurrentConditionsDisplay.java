package com.sherlocky.headfirst.pattern._02_observer;

/**
 * 此布告板实现了Observer接口，所以可以从weatherDataSubject对象中获得改变，
 *  还实现了DisplayElement接口，以作实际的显示。
 * @author: zhangcx
 * @date: 2018/12/23 15:29
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    // 保留Subject的引用看似没用，但是以后可能会取消注册，多有保留引用会比较方便
    private Subject weatherDataSubject;

    // 构造器需要weatherDataSubject对象（也就是主题）作为注册之用
    public CurrentConditionsDisplay(Subject weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        weatherDataSubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditions: " + temperature + "°（摄氏度） and " + humidity + "%（湿度） humidity and " + pressure + "hPa（百帕）");
    }

    /**
     * 当update()被调用时，我们把温度、湿度、气压保存起来，然后调用display()
     * @param temperature
     * @param humidity
     * @param pressure
     */
    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display(); // 更新显示
    }
}
