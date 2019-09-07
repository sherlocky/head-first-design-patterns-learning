package com.sherlocky.headfirst.pattern._06_command;

/**
 * 空命令对象
 * <p>是一个空对象（null object）的例子，当我们不想返回一个有意义的对象是，空对象就很有用。
 * 可以将处理null的责任转移给空对象</p>
 * <p>在许多设计模式中，都会看到空对象的使用，甚至有的时候，空对象本身也被视为是一种设计模式。</p>
 * @author: zhangcx
 * @date: 2019/9/2 21:40
 */
public class NoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("No Command!");
    }
}
