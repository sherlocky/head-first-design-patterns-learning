package com.sherlocky.headfirst.pattern._09_templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 咖啡
 */
public class CoffeeWithHook extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("过滤咖啡~");
    }

    @Override
    public void addCondiments() {
        System.out.println("加糖加奶~");
    }

	/**
	 * 覆盖了钩子方法，提供了自己的功能。
	 * @return 让用户输入他们对调料的决定，根据用户的输入返回true或false
	 */
	@Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }
        return false;
    }

	/**
	 * 询问客户时候加奶加糖，通过命令行获取用户输入。
	 * @return
	 */
	private String getUserInput() {
        String answer = null;
        System.out.println("咖啡是否加糖加奶 (y/n)? ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException ioe) {
            System.err.println("尝试读取回答时出现IO错误！");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}
