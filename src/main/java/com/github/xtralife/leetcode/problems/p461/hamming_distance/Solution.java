package com.github.xtralife.leetcode.problems.p461.hamming_distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((x & mask) != (y & mask)) {
                result++;
            }
            mask <<= 1;
        }
        return result;
    }
}
