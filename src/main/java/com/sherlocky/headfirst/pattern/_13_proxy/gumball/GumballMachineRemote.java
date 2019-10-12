package com.sherlocky.headfirst.pattern._13_proxy.gumball;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 1.为 GumballMachine 创建一个远程接口，提供一组可以远程调用的方法
 * 2.确定接口的返回值都是可序列化的
 * 3.在一个具体类中实现此接口
 */
public interface GumballMachineRemote extends Remote {
    public int getCount() throws RemoteException;

    public String getLocation() throws RemoteException;

    public State getState() throws RemoteException;
}
