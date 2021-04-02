package com.github.xtralife.leetcode.problems.p43.multiply_strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        List<String> toSum = new ArrayList<>();
        int pointer = num2.length() - 1;
        int longest = 0;
        while (pointer >= 0) {
            String inter = multiply(num1, num2.charAt(pointer), getSb(num2.length() - 1 - pointer));
            toSum.add(inter);
            longest = Math.max(longest, inter.length());
            pointer--;
        }
        return sum(toSum, longest);
    }

    private String multiply(String num, char digit, StringBuilder sb) {
        int dVal = digit - '0';
        int carry = 0;
        int pointer = num.length() - 1;
        while (pointer >= 0) {
            int res = dVal * (num.charAt(pointer) - '0') + carry;
            sb.append(res % 10);
            carry = res / 10;
            pointer--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.toString();
    }

    private StringBuilder getSb(int zeros) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }
        return sb;
    }

    private String sum(List<String> toSum, int length) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int pointer = 0;
        while (pointer < length) {
            int inter = carry;
            for (String num : toSum) {
                if (pointer >= num.length()) {
                    continue;
                }
                inter += num.charAt(pointer) - '0';
            }
            sb.append(inter % 10);
            carry = inter / 10;
            pointer++;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
