package com.sherlocky.headfirst.pattern._13_proxy.rmidemo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 远程接口的实现类
 * <p>做实际工作的类，为远程接口中定义的远程方法提供真正的实现。</p>
 * <p>这个就是客户想真正调用方法的对象。</p>
 *
 * <p>
 *     为了成为远程服务对象，对象需要具备远程功能，最简单的方式是扩展 {@link java.rmi.server.UnicastRemoteObject}。
 * </p>
 * @author: zhangcx
 * @date: 2019/10/11 16:43
 */
public class MyRemoteServiceImpl extends UnicastRemoteObject implements MyRemoteService {
    /**
     * {@link java.rmi.server.UnicastRemoteObject} 类的构造器会抛出 {@link RemoteException}，
     * 唯一解决办法就是实现一个构造函数，并抛出异常。
     */
    public MyRemoteServiceImpl() throws RemoteException {
        // 可以是空构造函数
    }

    /**
     * 服务必须实现远程接口
     *
     * @param name
     * @return
     * @throws RemoteException
     */
    @Override
    public String sayHello(String name) throws RemoteException {
        return String.format("服务端说：你好~%s", name);
    }
}
