package org.example.once.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//剑指 Offer 09. 用两个栈实现队列
public class CQueue {
    private Deque<Integer> stack1;

    private Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
