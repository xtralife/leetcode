package com.github.xtralife.leetcode.problems.p1209.remove_all_adjacent_duplicates_in_string_ii;

import java.util.Stack;

public class Solution {
    private static class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "ch=" + ch +
                    ", count=" + count +
                    '}';
        }
    }

    public String removeDuplicates(String s, int k) {
        if (s.isEmpty() || k == 1) return "";

        Stack<Pair> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                int count = stack.peek().count;
                if (count == k - 2) {
                    for (int i = 0; i < k - 1; i++) {
                        stack.pop();
                    }
                } else {
                    stack.push(new Pair(ch, count + 1));
                }
            } else {
                stack.push(new Pair(ch, 0));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop().ch);
        }
        return sb.reverse().toString();
    }
}
