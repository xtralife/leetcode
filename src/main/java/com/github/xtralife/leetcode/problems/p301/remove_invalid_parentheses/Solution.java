package com.github.xtralife.leetcode.problems.p301.remove_invalid_parentheses;

import java.util.*;

public class Solution {
    private final Set<String> validExpressions = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        validExpressions.clear();
        int left = 0;
        int right = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            }
            if (ch == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<>(validExpressions);
    }

    private void recurse(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder expr) {
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                validExpressions.add(expr.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        if (ch == '(' && leftRem > 0) {
            recurse(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, expr);
        }
        if (ch == ')' && rightRem > 0) {
            recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, expr);
        }
        expr.append(ch);
        if (ch == '(') {
            recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expr);
        }
        if (ch == ')' && leftCount > rightCount) {
            recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expr);
        }
        if (ch != '(' && ch != ')') {
            recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expr);
        }

        expr.deleteCharAt(expr.length() - 1);
    }
}
