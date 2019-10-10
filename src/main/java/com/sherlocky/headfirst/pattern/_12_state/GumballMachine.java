package com.sherlocky.headfirst.pattern._12_state;

/**
 * 糖果售卖机
 * <p>状态类中的方法直接映射到糖果机上可能发生的动作。</p>
 * <p>状态类实现了适合我们所在的这个状态的行为，在某些情况下这个行为会让糖果机的状态改变。</p>
 */
public class GumballMachine {
    /** 所有的状态都在这里 */
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;
    // 当前状态实例，默认状态是已售罄
    State state = soldOutState;
    /**
     * 默认糖果库存数量
     */
    int count = 0;

    public GumballMachine(int numberGumballs) {
        if (numberGumballs < 0) {
            throw new IllegalArgumentException("库存数量不能为负！");
        }
        // 每一种状态都创建一个状态实例
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        // 糖果库存
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            // 如果库存大于0，则初始状态为：没有25分硬币
            state = noQuarterState;
        }
    }

    /** 将动作都委托到状态类 */
    /**
     * 投入25美分硬币
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * 退出25美分硬币
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 转动售卖机曲柄
     */
    public void turnCrank() {
        // 调用对应状态的转动曲柄 和 发放糖果
        state.turnCrank();
        // dispense 属于内部动作，用户不会直接要求机器发放糖果
        state.dispense();
    }

    /**
     * 推出糖果
     */
    void releaseBall() {
        System.out.println("一颗糖果正在滚出...");
        if (count != 0) {
            count = count - 1;
        }
    }

    /**
     * 重新装满糖果机
     * @param count
     */
    void refill(int count) {
        this.count += count;
        System.out.println(String.format("糖果机刚刚装满了; 新的库存是: %i 颗。", this.count));
        state.refill();
    }

    int getCount() {
        return count;
    }

    public State getState() {
        return state;
    }

    /**
     * 允许其他对象将机器的状态转换到不同的状态
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\n强大糖果公司.");
        result.append("\n库存: " + count + " 颗糖果。");
        result.append("\n");
        result.append("机器目前处于 " + state + " 状态\n");
        return result.toString();
    }
}