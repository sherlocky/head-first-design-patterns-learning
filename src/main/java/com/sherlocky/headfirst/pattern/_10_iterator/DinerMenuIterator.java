package com.sherlocky.headfirst.pattern._10_iterator;

import java.util.Iterator;

/**
 * 正餐菜单 迭代器
 */
public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] list;
    int position = 0;

    public DinerMenuIterator(MenuItem[] list) {
        this.list = list;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = list[position];
        position = position + 1;
        return menuItem;
    }

	@Override
    public boolean hasNext() {
        if (position >= list.length || list[position] == null) {
            return false;
        } else {
            return true;
        }
    }

	@Override
    public void remove() {
        if (position <= 0) {
            throw new IllegalStateException("你必须完成至少一个 next() 才能删除项目");
        }
        if (list[position - 1] != null) {
            for (int i = position - 1; i < (list.length - 1); i++) {
                list[i] = list[i + 1];
            }
            list[list.length - 1] = null;
        }
    }

}
