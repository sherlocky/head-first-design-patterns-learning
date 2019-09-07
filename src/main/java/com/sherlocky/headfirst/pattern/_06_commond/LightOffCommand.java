package com.sherlocky.headfirst.pattern._06_commond;

/**
 * 电灯关闭命令
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

	@Override
    public void execute() {
        light.off();
    }


}
