package com.github.xtralife.leetcode.problems.p621.task_scheduler;

import java.util.*;

public class Solution {
    static class Task {
        char code;
        int count;

        public Task(char code, int count) {
            this.code = code;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public void decreaseCount() {
            count--;
        }

        public void increaseCount() {
            count++;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "code=" + code +
                    ", count=" + count +
                    '}';
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char ch : tasks) {
            counts[ch - 'A']++;
        }

        PriorityQueue<Task> queue = new PriorityQueue<>(Comparator.comparingInt(Task::getCount).reversed());
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            if (counts[ch - 'A'] > 0) {
                queue.add(new Task(ch, counts[ch - 'A']));
            }
        }
        Map<Integer, Task> cooldownTasks = new HashMap<>();
        int units = 0;
        while (!queue.isEmpty() || !cooldownTasks.isEmpty()) {
            if (cooldownTasks.containsKey(units)) {
                queue.add(cooldownTasks.remove(units));
            }
            units++;
            if (queue.isEmpty()) {
                continue;
            }
            Task task = queue.poll();
            task.decreaseCount();
            if (task.count > 0) {
                cooldownTasks.put(units + n, task);
            }
        }
        return units;
    }
}
