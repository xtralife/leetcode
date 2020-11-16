package com.github.xtralife.leetcode.problems.p91.decode_ways;

public class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        if (length == 1) {
            return 1;
        }
        int[] numDecodings = new int[length];
        numDecodings[0] = 1;
        for (int pointer = 1; pointer < length; pointer++) {
            boolean valid = isValid(s, pointer);
            if (s.charAt(pointer) == '0') {
                if (valid) {
                    numDecodings[pointer] = getNumDecodings(numDecodings, pointer - 2);
                } else {
                    return 0;
                }
            } else {
                if (valid) {
                    numDecodings[pointer] = numDecodings[pointer - 1] + getNumDecodings(numDecodings, pointer - 2);
                } else {
                    numDecodings[pointer] = numDecodings[pointer - 1];
                }
            }
        }
        return numDecodings[length - 1];
    }

    private boolean isValid(String s, int pointer) {
        return s.charAt(pointer - 1) == '1' || (s.charAt(pointer - 1) == '2' && s.charAt(pointer) <= '6');
    }

    private int getNumDecodings(int[] numDecodings, int pointer) {
        if (pointer < 0) {
            return 1;
        }
        return numDecodings[pointer];
    }
}
