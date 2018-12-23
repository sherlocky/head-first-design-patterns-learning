package com.sherlocky.headfirst.pattern._02_observer.use_java_api;

/**
 * 使用 Java 内置API实现的气象数据更新显示
 * <p><strong>观察者被通知的次序变了</strong> Observable实现了自己的notifyObservers()方法，这导致了通知观察者的次序不同于我们注册时的顺序</p>
 * <p>查看源码可以得知，通知时是按照注册时的顺序<strong>倒序</strong>通知的。</p>
 * <p>Observable是一个类不是一个接口，更糟糕的是，它甚至没有实现一个接口。这限制了它的复用潜力（）。必要的时候可以自己实现这一整套观察者模式。</p>
 * @author: zhangcx
 * @date: 2018/12/23 16:54
 */
public class WeatherStationUseJavaAPI {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        // 注册观察者
        GeneralDisplay generalDisplay = new GeneralDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(30, 65, 1800f);
        weatherData.setMeasurements(32, 70, 1000f);
        weatherData.setMeasurements(38, 45, 1500f);
    }
}
/**=== 输出结果如下：
 Forecast: Improving weather on the way!
 Avg/Max/Min temperature = 30.0/30.0/30.0
 General（use Java API）: 30.0°（摄氏度） and 65.0%（湿度） humidity and 1800.0hPa（百帕）
 Forecast: Watch out for cooler, rainy weather
 Avg/Max/Min temperature = 31.0/32.0/30.0
 General（use Java API）: 32.0°（摄氏度） and 70.0%（湿度） humidity and 1000.0hPa（百帕）
 Forecast: Improving weather on the way!
 Avg/Max/Min temperature = 33.333332/38.0/30.0
 General（use Java API）: 38.0°（摄氏度） and 45.0%（湿度） humidity and 1500.0hPa（百帕）
*/