package com.github.xtralife.leetcode.problems.p622.design_circular_queue.array;

public class MyCircularQueue {
    private final int[] array;
    private final int length;
    private int head;
    private int tail;
    private int total;

    public MyCircularQueue(int k) {
        length = k;
        array = new int[length];
        head = 0;
        tail = 0;
        total = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        array[head] = value;
        head = next(head);
        total++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        tail = next(tail);
        total--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return array[tail];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[prev(head)];
    }

    public boolean isEmpty() {
        return total == 0;
    }

    public boolean isFull() {
        return total == length;
    }

    private int next(int value) {
        if (value == length - 1) {
            return 0;
        }
        return value + 1;
    }

    private int prev(int value) {
        if (value == 0) {
            return length - 1;
        }
        return value - 1;
    }
}
