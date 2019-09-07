package com.sherlocky.headfirst.pattern._06_commond;

/**
 * 电灯关闭命令
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
