package p101_200.p155最小栈;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目要求在常数时间内获得栈中的最小值，因此不能在 getMin() 的时候再去计算最小值，
 * 最好应该在 push 或者 pop 的时候就已经计算好了当前栈中的最小值。
 *
 * 一般用辅助栈来实现，与元素栈同步插入与删除，用于存储与每个元素对应的最小值。
 *      1) 当一个元素要入栈时，取辅助栈的栈顶存储的最小值，与当前元素比较得出最小值，将这个最小值插入辅助栈中；
 *      2) 当一个元素要出栈时，把辅助栈的栈顶元素也一并弹出；
 *      3) 在任意一个时刻，栈内元素的最小值就存储在辅助栈的栈顶元素中。
 *
 * 当然，不使用辅助栈，用一个栈也可以实现，例如，
 * 栈同时保存的是每个元素进栈的时候的值 与 插入该值后的栈内最小值，
 * 即每次新元素 x 入栈的时候保存一个元组：（当前值 x，栈内最小值），这个元组是一个整体，同时进栈和出栈。。
 * 这种做法空间复杂度和辅助栈是一样的。
 *
 */
class MinStack {

    Deque<Integer> xStack;
    Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}