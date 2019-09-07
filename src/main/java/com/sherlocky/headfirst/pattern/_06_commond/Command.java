package com.sherlocky.headfirst.pattern._06_commond;

/**
 * 命令 接口
 * @author: zhangcx
 * @date: 2019/9/2 21:36
 */
public interface Command {
    /**
     * 命令的执行方法（实现类需要实现该方法）
     */
    void execute();
}
