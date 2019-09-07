package com.sherlocky.headfirst.pattern._06_command;
import java.util.Arrays;

/**
 * 遥控器类
 * <p>充当命令模式中的调用者</p>
 * <p>实现遥控器控制打开多种电器的功能</p>
 *
 * @author: zhangcx
 * @date: 2019/9/2 21:35
 */
public class RemoteControl {
    private int slotSize;
    /** 控制打开的命令（遥控器上ON按钮） */
    private Command[] onCommands;
    /** 控制关闭的命令（遥控器上OFF按钮） */
    private Command[] offCommands;

    public RemoteControl() {
        // 默认7个按钮
        this(7);
    }

    public RemoteControl(int slotSize) {
        this.slotSize = slotSize;
        onCommands = new Command [slotSize];
        offCommands = new Command [slotSize];
        // 实例化开关（插槽上的）数组
        Command noCommand = new NoCommand();
        for (int i = 0; i < slotSize; i++) {
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    /**
     * @param slotPosition 插槽(按钮)位置
     * @param onCommand ON 命令
     * @param offCommand OFF 命令
     */
    public void setCommand(int slotPosition, Command onCommand, Command offCommand) {
        onCommands[slotPosition] = onCommand;
        offCommands[slotPosition] = offCommand;
    }

    public void onButtonWasPushed(int slotPosition) {
        onCommands[slotPosition].execute();
    }

    public void offButtonWasPushed(int slotPosition) {
        offCommands[slotPosition].execute();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "slotSize=" + slotSize +
                ", onCommands=" + Arrays.toString(onCommands) +
                ", offCommands=" + Arrays.toString(offCommands) +
                '}';
    }
}
