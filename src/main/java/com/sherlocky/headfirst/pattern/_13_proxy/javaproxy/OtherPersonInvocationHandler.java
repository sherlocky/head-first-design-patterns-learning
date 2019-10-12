package com.sherlocky.headfirst.pattern._13_proxy.javaproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * “别人的”调用处理器
 */
public class OtherPersonInvocationHandler implements InvocationHandler {
    PersonBean person;

    public OtherPersonInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws IllegalAccessException {

        try {
            // 可以获取“别人”的信息
            if (method.getName().startsWith("get")) {
                return method.invoke(person, args);
            } else if (method.getName().equals("setHotOrNotRating")) {
                // 可以给别人评分
                return method.invoke(person, args);
            } else if (method.getName().startsWith("set")) {
                // 不能修改别人的信息
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
