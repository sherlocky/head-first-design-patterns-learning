package com.sherlocky.headfirst.pattern._13_proxy.rmidemo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 定义远程接口
 *
 * <p>定义出可以让客户远程调用的方法，客户将他作为服务的类类型。</p>
 * <p>stub 和实际的服务都实现此接口。</p>
 *
 * <p>Remote 是一个记号接口，不具有方法，约定。</p>
 * @author: zhangcx
 * @date: 2019/10/11 16:41
 */
public interface MyRemoteService extends Remote {

    /**
     * 客户使用远程接口调用服务——客户会调用实现远程接口的 Stub 上的方法，底层使用了网络和I/O。
     * 声明所有的方法都会抛出 RemoteException
     *
     * 需要确定参数和返回值，都必须属于原语类型或 Serializable 类型（因为需要序列化和传输）。
     */
    public String sayHello(String name) throws RemoteException;
}
