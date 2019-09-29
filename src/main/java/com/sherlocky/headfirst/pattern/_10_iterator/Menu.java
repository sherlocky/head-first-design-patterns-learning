package com.sherlocky.headfirst.pattern._10_iterator;

import java.util.Iterator;

/**
 * 菜单接口
 */
public interface Menu {
    public Iterator<MenuItem> createIterator();
}
