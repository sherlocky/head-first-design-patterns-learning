package com.sherlocky.headfirst.pattern._13_proxy.javaproxy;

/**
 * PersonBean 不允许别人随意修改自己的数据，也不允许自己给自己评分，
 * 但是自己可以修改自己的数据，不能给自己评分。
 * <p>可以使用：保护代理，借助 Java 的动态代理来实现（Java 已提供了 Proxy 类）</p>
 */
public interface PersonBean {

    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    void setHotOrNotRating(int rating);

}
