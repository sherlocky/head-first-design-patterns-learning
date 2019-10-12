package com.sherlocky.headfirst.pattern._13_proxy.gumball;

/**
 * 幸运用户（赢家） -- 状态类
 */
public class WinnerState implements State {
    transient GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("请稍等，已经在给你分配糖果");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("请稍等，已经给你分配了糖果");
    }

    @Override
    public void turnCrank() {
        System.out.println("转动两次也无法得到更多糖果!");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        // 如果没有库存进入 糖果已售罄状态
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
            return;
        }
        // 幸运用户会推出两颗糖果
        gumballMachine.releaseBall();
        System.out.println("你是幸运用户，你得到了两颗糖果。");
        // 推出两颗糖果后，如果还有库存，则进入 没有投入硬币状态
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
        return "幸运用户，分配到两颗糖果~";
    }
}
