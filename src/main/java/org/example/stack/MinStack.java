package org.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    private Deque<Integer> minStack;

    private Deque<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        minStack = new ArrayDeque<>();
        stack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
//        System.out.println(minStack.min());
//        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}
