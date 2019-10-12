package com.sherlocky.headfirst.pattern._13_proxy.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * “自己的”调用处理器
 *
 * 所有调用处理器都需要实现 InvocationHandler 接口。
 *
 * <p>InvocationHandler 实现了代理的行为，Java 负责创建真实的代理类和对象。
 * 只需要提供在方法调用发生时知道做什么的 handler</p>
 *
 * <p>当代理的方法被调用时，代理就会把这个调用转发给 InvocationHandler，但是</p>
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    /**
     * 将 person 传入调用处理器的构造器，并保存一份
     * @param person
     */
    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    /**
     * 每次 proxy 的方法被调用，就会导致 proxy 调用此方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws IllegalAccessException
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException {
        try {
            // 如果是getter方法 就调用 person 的方法
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
                // 如果是 评分 方法，就抛出异常表示不允许（不能给自己评分）
            } else if (method.getName().equals("setHotOrNotRating")) {
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")) {
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException e) {
            // 如果真正主题对象抛出异常的话，就会执行到这里
            e.printStackTrace();
        }
        // 如果调用其他方法，一律不理，返回 null
        return null;
    }
}
