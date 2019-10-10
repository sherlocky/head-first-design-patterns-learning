package com.sherlocky.headfirst.pattern._12_state;

import java.util.Random;

/**
 * 已投入硬币 -- 状态类
 *
 * <p>As same as {@link NoQuarterState}</p>
 * @author
 */
public class HasQuarterState implements State {
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        // 这是一个对此状态不恰当的动作
        System.out.println("你不能再投入一个硬币！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("硬币已退回");
        // 退出顾客的硬币，并进入没有投入硬币状态
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("你转动了曲柄...");
        /**
         * 强大糖果公司的花样玩法：转动曲柄时有10%的几率掉下来两颗糖果（多送顾客一颗）
         */
        // nextInt 返回可能值范围：0 - 9
        int winner = randomWinner.nextInt(10);
        if (winner == 0 && gumballMachine.getCount() > 1) {
            // 幸运客户（赢家）进入赢家状态
            gumballMachine.setState(gumballMachine.getWinnerState());
            return;
        }
        // 普通客户进入 已售出状态
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    @Override
    public void dispense() {
        // 此状态下另一个不恰当的动作
        System.out.println("没有分配糖果！");
    }

    @Override
    public void refill() {
    }

    @Override
    public String toString() {
        return "等待转动曲柄~";
    }
}
