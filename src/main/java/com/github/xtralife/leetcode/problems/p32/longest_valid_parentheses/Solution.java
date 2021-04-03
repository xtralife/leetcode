package com.github.xtralife.leetcode.problems.p32.longest_valid_parentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else if (stack.size() > 1) {
                int current = stack.pop() + stack.pop() + 2;
                max = Math.max(max, current);
                stack.push(current);
            } else {
                stack.pop();
                stack.push(0);
            }
        }
        return Math.max(max, stack.pop());
    }
}
