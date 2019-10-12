package com.sherlocky.headfirst.pattern._13_proxy.javaproxy;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class PersonProxyTestDrive {
    /**
     * 模拟数据库
     */
    HashMap<String, PersonBean> datingDB = new HashMap<String, PersonBean>();

    public static void main(String[] args) {
        PersonProxyTestDrive test = new PersonProxyTestDrive();
        test.drive();
    }

    public PersonProxyTestDrive() {
        initializeDatabase();
    }

    public void drive() {
        PersonBean lilei = getPersonFromDatabase("李雷");
        System.out.println("###### 获得“自己”的代理 ######");

        PersonBean ownerProxy = getOwnerProxy(lilei);
        System.out.println("姓名：" + ownerProxy.getName());
        ownerProxy.setInterests("保龄球，散步");
        System.out.println("通过“自己”的代理设置个人兴趣爱好~");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("不能给自己评分！");
        }
        System.out.println("评分：" + ownerProxy.getHotOrNotRating());

        System.out.println("###### 获得“别人”的代理 ######");
        PersonBean nonOwnerProxy = getOtherPersonProxy(lilei);
        System.out.println("姓名：" + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("保龄球，散步");
        } catch (Exception e) {
            System.out.println("不能通过“别人”的代理修改别人的兴趣爱好！");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("通过“别人”的代理给别人评分~");
        System.out.println("评分：" + nonOwnerProxy.getHotOrNotRating());
    }

    PersonBean getOwnerProxy(PersonBean person) {
        /**
         * Proxy.newProxyInstance 需要的参数：
         * 1.被代理对象的类加载器
         * 2.代理需要实现的接口
         * 3.调用处理器（需要将被代理对象传入调用处理器构造器中）
         */
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }

    PersonBean getOtherPersonProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OtherPersonInvocationHandler(person));
    }

    PersonBean getPersonFromDatabase(String name) {
        return (PersonBean) datingDB.get(name);
    }

    /**
     * 将李雷和韩梅梅加入到 模拟的数据库中
     */
    void initializeDatabase() {
        PersonBean ll = new PersonBeanImpl();
        ll.setName("李雷");
        ll.setInterests("汽车，电脑，音乐");
        ll.setHotOrNotRating(7);
        datingDB.put(ll.getName(), ll);

        PersonBean hmm = new PersonBeanImpl();
        hmm.setName("韩梅梅");
        hmm.setInterests("网购，电影，音乐");
        hmm.setHotOrNotRating(6);
        datingDB.put(hmm.getName(), hmm);
    }
}
