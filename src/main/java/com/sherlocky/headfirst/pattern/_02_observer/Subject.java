package com.sherlocky.headfirst.pattern._02_observer;

/**
 * Java 为观察者模式提供了内置的支持，但是我们还是先手动实现一套
 * <p>以气象站布告板要实时更新气象信息为例</p>
 * @author: zhangcx
 * @date: 2018/12/23 15:02
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    // 当主题改变时，这个方法会被调用，以通知所有的观察者
    public void notifyObservers();
}
