package com.sherlocky.headfirst.pattern._13_proxy.gumball;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 创建 GumballMachine 的实例并在 rmiregistry 中注册。
 * @author: zhangcx
 * @date: 2019/10/11 18:51
 */
public class GumballMachineRMIServer {
    /**
     * 默认就是 1099
     */
    public static final int RMI_BIND_PORT = 1099;
    public static final String RMI_BIND_NAME = "GumballMachine";
    public static void main(String[] args) {
        try {
            // 注册远程对象,向客户端提供远程对象服务。
            // 远程对象是在远程服务上创建的，你无法确切地知道远程服务器上的对象的名称，
            // 但是,将远程对象注册到RMI Registry之后,
            // 客户端就可以通过RMI Registry请求到该远程服务对象的stub，
            // 利用stub代理就可以访问远程服务对象了。
            GumballMachineRemote remote = new GumballMachine("软件园", 10);
            LocateRegistry.createRegistry(RMI_BIND_PORT);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind(RMI_BIND_NAME, remote);
            System.out.println(String.format("GumballMachine 准备好了~注册端口：%d", RMI_BIND_PORT));
            // 如果不想再让该对象被继续调用，使用下面一行
            // UnicastRemoteObject.unexportObject(remote, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
