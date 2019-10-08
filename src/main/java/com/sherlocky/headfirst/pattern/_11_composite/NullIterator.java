package com.sherlocky.headfirst.pattern._11_composite;

import java.util.Iterator;

/**
 * 空迭代器
 * <p>
 *     属于空对象 设计模式 的一个例子。
 * </p>
 * <p>
 *     我们可以有两种选择来实现 菜单项(叶节点)的 createIterator() 方法：
 *     <ul>
 *         <li>1.返回null: 这么做，客户端代码必须判断返回值是否为null。</li>
 *         <li>2.返回一个迭代器，而这个迭代器的 hasNext() 永远为 false。</li>
 *     </ul>
 * </p>
 */
public class NullIterator implements Iterator<MenuComponent> {
    @Override
    public MenuComponent next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        // 当迭代器被调用时，永远返回 false
        return false;
    }
}
