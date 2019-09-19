package com.sherlocky.headfirst.pattern._09_templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 茶
 */
public class TeaWithHook extends CaffeineBeverage {

    @Override
    public void brew() {
        System.out.println("泡茶。。。");
    }

    @Override
    public void addCondiments() {
        System.out.println("加柠檬~");
    }


    @Override
    public boolean customerWantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().startsWith("y")) {
            return true;
        }
        return false;
    }

    private String getUserInput() {
        String answer = null;
        System.out.println("茶是否加柠檬(y/n)? ");
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
