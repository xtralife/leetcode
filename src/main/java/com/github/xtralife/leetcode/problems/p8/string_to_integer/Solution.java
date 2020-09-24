package com.github.xtralife.leetcode.problems.p8.string_to_integer;

public class Solution {
    public int myAtoi(String str) {
        int index = 0;
        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c) || c == '-' || c == '+') {
                break;
            }
            return 0;
        }
        if (index == str.length()) {
            return 0;
        }
        boolean negative = str.charAt(index) == '-';
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        int result = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit > 8)) {
                return Integer.MIN_VALUE;
            }
            if (result >= 0) {
                result = result * 10 + digit;
            } else {
                result = result * 10 - digit;
            }
            if (result > 0 && negative) {
                result = -result;
            }
            index++;
        }
        return result;
    }
}
