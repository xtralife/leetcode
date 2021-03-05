package com.github.xtralife.leetcode.problems.p50.pow_x_n.recursion;

public class Solution {
    public double myPow(double x, int n) {
        double base = n < 0 ? 1 / x : x;
        int pow = Math.abs(n);
        return fastPow(base, pow);
    }
    private double fastPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
}
