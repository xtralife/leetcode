package com.github.xtralife.leetcode.problems.p1249.minimum_remove_to_make_valid_parentheses;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        return removeUnbalanced(removeUnbalanced(s, '(', ')'), ')', '(');
    }

    private String removeUnbalanced(String input, char inc, char dec) {
        int balance = 0;
        StringBuilder builder = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (ch == inc) {
                balance++;
            }
            if (ch == dec) {
                balance--;
            }
            if (balance < 0) {
                balance = 0;
            } else {
                builder.append(ch);
            }
        }
        return builder.reverse().toString();
    }
}
