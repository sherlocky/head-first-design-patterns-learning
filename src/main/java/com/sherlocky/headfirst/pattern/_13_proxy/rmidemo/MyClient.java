package com.sherlocky.headfirst.pattern._13_proxy.rmidemo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 1.启动之前一定要先启动 rmiregistry
 * 2.让变量和返回值的类型成为可序列化的类型
 * 3.记得提供 stub 类
 *
 * @author: zhangcx
 * @date: 2019/10/11 17:24
 */
public class MyClient {

    public static void main(String[] args) {
        try {
            // 如果RMI Registry就在本地机器上，URL就是:rmi://localhost:1099/MyRemoteHello
            // 否则，URL就是：rmi://RMIService_IP:1099/MyRemoteHello，端口要和服务端对应
            Registry registry = LocateRegistry.getRegistry("localhost");
            // 从Registry中检索远程对象的存根/代理
            MyRemoteService remote = (MyRemoteService) registry.lookup("MyRemoteHello");
            // 调用远程对象的方法
            String ss = remote.sayHello("MyClientX");
            System.out.println(ss);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
