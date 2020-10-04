package com.github.xtralife.leetcode.problems.p415.add_strings;

public class Solution {
    public String addStrings(String num1, String num2) {
        String first;
        String second;
        if (num1.length() > num2.length()) {
            first = num1;
            second = num2;
        } else {
            first = num2;
            second = num1;
        }
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int shift = first.length() - second.length();
        for (int i = second.length() - 1; i >= 0; i--) {
            int sum = first.charAt(i + shift) + second.charAt(i) - '0' - '0' + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        for (int i = first.length() - second.length() - 1; i >= 0; i--) {
            int sum = first.charAt(i) - '0' + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.addStrings("98", "9");
        System.out.println(result);
    }
}
