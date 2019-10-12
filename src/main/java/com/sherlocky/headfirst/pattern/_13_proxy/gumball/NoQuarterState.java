package com.sherlocky.headfirst.pattern._13_proxy.gumball;

/**
 * 没有25分硬币 -- 状态类
 * <p>实现了{@link State}接口</p>
 *
 * <p>为机器中的每个状态实现状态类，这些类将负责在对应的状态下，进行机器的行为。</p>
 *
 * @author
 */
public class NoQuarterState implements State {
    transient GumballMachine gumballMachine;

    /**
     * 通过构造器得到糖果机的引用，并保存到实例变量中。
     * @param gumballMachine
     */
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        /**
         * 如果有人投入了 25分硬币，打印一条消息
         * 并改变机器状态为 {@link HasQuarterState}
         */
        System.out.println("你投入了25分硬币。");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没有投入硬币，无法退回。");
    }

    @Override
    public void turnCrank() {
        System.out.println("你还没有投入硬币，转动曲柄无效！");
    }

    @Override
    public void dispense() {
        System.out.println("你还没有投入硬币，无法发放糖果！");
    }

    @Override
    public void refill() {
    }

    @Override
    public String toString() {
        return "等待投入硬币~";
    }
}
