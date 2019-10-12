package com.sherlocky.headfirst.pattern._13_proxy.gumball;

/**
 * 糖果已售罄 -- 状态类
 */
public class SoldOutState implements State {
    transient GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("不能投入硬币了，本机器已售罄。");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你不能退回硬币，应为没有投币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("没有糖果了！");
    }

    @Override
    public void dispense() {
        System.out.println("没有糖果分配。");
    }

    @Override
    public void refill() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public String toString() {
        return "已售罄~";
    }
}
