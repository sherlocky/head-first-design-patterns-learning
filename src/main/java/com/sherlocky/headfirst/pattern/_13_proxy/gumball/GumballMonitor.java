package com.sherlocky.headfirst.pattern._13_proxy.gumball;

import java.rmi.RemoteException;

/**
 * 糖果监视器 -- 作为远程调用的客户端
 */
public class GumballMonitor {
    /**
     * 依赖远程接口，而不是具体的实现类
     */
    GumballMachineRemote machine;

    public GumballMonitor(GumballMachineRemote machine) {
        this.machine = machine;
    }

    public void report() {
        try {
            System.out.println("糖果售卖机: " + machine.getLocation());
            System.out.println("当前库存: " + machine.getCount() + " 颗");
            System.out.println("当前状态: " + machine.getState());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
