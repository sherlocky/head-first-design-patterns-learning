package com.sherlocky.headfirst.pattern._13_proxy.gumball;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 以糖果机监视器远程监控糖果机运行情况为例（获取糖果机器的远程代理）
 * <p>需要先运行 {{@link GumballMachineRMIServer#main(String[])}}</p>
 */
public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        GumballMachineRMIServer.main(null);
        try {
            // 如果RMI Registry就在本地机器上，URL就是:rmi://localhost:1099/MyRemoteHello
            // 否则，URL就是：rmi://RMIService_IP:1099/MyRemoteHello，端口要和服务端对应
            Registry registry = LocateRegistry.getRegistry("localhost", GumballMachineRMIServer.RMI_BIND_PORT);
            // 从Registry中检索远程对象的存根(桩)/代理
            // 此处获得了糖果机器的远程代理
            GumballMachineRemote remote = (GumballMachineRemote) registry.lookup(GumballMachineRMIServer.RMI_BIND_NAME);
            GumballMonitor monitor = new GumballMonitor(remote);
            monitor.report();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
