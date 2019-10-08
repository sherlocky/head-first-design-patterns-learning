package com.sherlocky.headfirst.pattern._11_composite;

import java.util.Iterator;
import java.util.Stack;

/**
 * 组合迭代器（“外部迭代器”）
 * <p>遍历组件内的菜单项，而且确保所有的子菜单（以及子子菜单。。）都被包括进来</p>
 *
 * <p>
 *     外部迭代器必须维护它在遍历中的位置，以便外部客户可以通过调用 hasNext() 和 next() 来驱动遍历。
 * </p>
 * <p>
 *     这里我们必须维护组合递归结构的位置，所以使用堆栈存储。
 * </p>
 */
public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<Iterator<MenuComponent>>();

    // 将我们要遍历的顶层组合的迭代器传入，将其放入一个堆栈中(顶部)。
    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            // 查看堆栈顶部的对象，但不移除它
            Iterator<MenuComponent> iterator = stack.peek();
            // 如果还有下一个元素，我们就从堆栈中取出目前的迭代器，然后取得它的下一个元素
            MenuComponent component = iterator.next();
            /**
             * 如果元素是一个菜单，我们就有了另一个需要被包含进遍历中的组合，
             * 所以将其放入栈中。
             * 然后，不管是不是菜单，我们都返回该组件。
             */
            stack.push(component.createIterator());
            return component;
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        // 想要知道是否还有下一个元素，我们检查堆栈是否被清空，如果已经空了，就表示没有下一个元素了。
        if (stack.empty()) {
            return false;
        } else {
            /**
             * 否则，我们就从堆栈的顶部取出一个迭代器，看看是否还有下一个元素。
             * 如果它没有元素，我们将它弹出堆栈，然后递归地调用 hasNext();
             */
            Iterator<MenuComponent> iterator = stack.peek();
            if (!iterator.hasNext()) {
                // 移除堆栈顶部的对象，并返回该对象
                stack.pop();
                return hasNext();
            } else {
                // 如果迭代器还存在下一个元素，返回 true
                return true;
            }
        }
    }
}


