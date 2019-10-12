package com.sherlocky.headfirst.pattern._13_proxy.gumball;

/**
 * 已售出 -- 状态类
 */
public class SoldState implements State {
    transient GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请稍等，已经在给你分配一颗糖果");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("抱歉，你已经转动了曲柄。");
    }

    @Override
    public void turnCrank() {
        System.out.println("转动两次也无法得到更多糖果!");
    }

    @Override
    public void dispense() {
        // 推出一个糖果
        gumballMachine.releaseBall();
        // 如果仍有库存，进入 没有投入硬币状态
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
            return;
        }
        // 没有库存则进入 糖果已售罄状态
        System.out.println("哎呀，糖果没有库存了!");
        gumballMachine.setState(gumballMachine.getSoldOutState());
    }

    @Override
    public void refill() {
    }

    @Override
    public String toString() {
        return "分发一颗糖果~";
    }
}
