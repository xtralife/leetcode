package com.github.xtralife.leetcode.problems.p190.reverse_bits;

// INCORRECT!!!!
public class Solution {
    // you need treat n as an unsigned value
    // INCORRECT!!!!
    public int reverseBits(int n) {
        int result = 0;
        int power = 31;
        while (n != 0) {
            result += (n & 1) << power--;
            n >>= 1;
        }
        return result;
    }
}
