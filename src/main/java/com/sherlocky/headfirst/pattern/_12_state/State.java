package com.sherlocky.headfirst.pattern._12_state;

/**
 * 定义一个状态接口
 * <p>以糖果售卖机为例，糖果售卖流程大致为：没有投入硬币->投入硬币->转动曲柄->发放糖果。</p>
 * <p>售卖机有多种状态，在这个接口里，糖果机的每个动作都有一个对应(映射)的方法。</p>
 * <ul>
 *     <li>没有25分硬币</li>
 *     <li>有25分硬币</li>
 *     <li>糖果售出</li>
 *     <li>糖果售罄</li>
 *     <li>赢得奖励</li>
 * </ul>
 * <p>设计中的所有状态都封装成一个类，状态类都必须实现这个接口，将每个状态的行为局部化到它自己的类中：</p>
 * <ul>
 *     <li>{@link NoQuarterState}</li>
 *     <li>{@link HasQuarterState}</li>
 *     <li>{@link SoldState}</li>
 *     <li>{@link SoldOutState}</li>
 *     <li>{@link WinnerState}</li>
 * </ul>
 * <p>让每一个状态“对修改关闭”，让糖果机对“对扩展开放”，因为可以加入新的状态类。</p>
 * @author: zhangcx
 * @date: 2019/10/10 10:41
 */
public interface State {
    /**
     * 投入25美分硬币
     */
    public void insertQuarter();

    /**
     * 退出25美分硬币
     */
    public void ejectQuarter();

    /**
     * 转动售卖机曲柄
     */
    public void turnCrank();

    /**
     * 发放糖果
     */
    public void dispense();

    /**
     * 重新装满糖果
     */
    public void refill();
}
