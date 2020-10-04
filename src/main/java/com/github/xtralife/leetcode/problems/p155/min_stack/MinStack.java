package com.github.xtralife.leetcode.problems.p155.min_stack;

public class MinStack {
    private static class Node {
        private final int value;
        private final Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node stack;
    private Node minStack;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if (stack == null) {
            stack = new Node(x, null);
            minStack = new Node(x, null);
        } else {
            stack = new Node(x, stack);
            if (minStack.value >= x) {
                minStack = new Node(x, minStack);
            }
        }
    }

    public void pop() {
        int x = stack.value;
        stack = stack.next;
        if (x == minStack.value) {
            minStack = minStack.next;
        }
    }

    public int top() {
        return stack.value;
    }

    public int getMin() {
        return minStack.value;
    }
}
