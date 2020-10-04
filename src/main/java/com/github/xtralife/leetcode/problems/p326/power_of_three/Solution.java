package com.github.xtralife.leetcode.problems.p326.power_of_three;

public class Solution {
    public boolean isPowerOfThree(int n) {
        return n == 3 || n > 0 && n % 3 == 0 && isPowerOfThree(n / 3);
    }
}
