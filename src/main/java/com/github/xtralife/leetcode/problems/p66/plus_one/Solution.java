package com.github.xtralife.leetcode.problems.p66.plus_one;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = digits[i];
            digits[i] = (digit + carry) % 10;
            carry = (digit + carry) / 10;
        }
        if (carry == 0) {
            return digits;
        }
        int[] result = new int[digits.length + 1];
        result[0] = carry;
        System.arraycopy(digits, 0, result, 1, digits.length);
        return result;
    }
}
