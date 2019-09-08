package com.sherlocky.headfirst.pattern._08_facade;

/**
 * 汽车钥匙类 -- 子系统角色
 * @author: zhangcx
 * @date: 2019/9/8 20:47
 */
public class CarKey {
    public void insert() {
        System.out.println("插入汽车钥匙~");
    }

    public void pullOut() {
        System.out.println("拔出汽车钥匙~");
    }
}
