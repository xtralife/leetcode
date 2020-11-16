package com.github.xtralife.leetcode.problems.p91.decode_ways.constant_space;

public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int preLast = 1;
        int last = 1;
        for (int pointer = 1; pointer < length; pointer++) {
            boolean valid = isValid(s, pointer);
            if (s.charAt(pointer) == '0') {
                if (valid) {
                    int temp = preLast;
                    preLast = last;
                    last = temp;
                } else {
                    return 0;
                }
            } else {
                if (valid) {
                    int temp = preLast + last;
                    preLast = last;
                    last = temp;
                } else {
                    preLast = last;
                }
            }
        }
        return last;
    }

    private boolean isValid(String s, int pointer) {
        return s.charAt(pointer - 1) == '1' || (s.charAt(pointer - 1) == '2' && s.charAt(pointer) <= '6');
    }
}
