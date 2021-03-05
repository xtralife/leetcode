package com.github.xtralife.leetcode.problems.p50.pow_x_n.bruteforce;

public class Solution {
    public double myPow(double x, int n) {
        double base = n < 0 ? 1 / x : x;
        int pow = Math.abs(n);
        double result = 1;
        for (int i = 0; i < pow; i++) {
            result *= base;
        }
        return result;
    }
}
