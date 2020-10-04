package com.github.xtralife.leetcode.problems.p191.number_of_1_bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) == 1) {
                result++;
            }
            mask <<= 1;
        }
        return result;
    }
}