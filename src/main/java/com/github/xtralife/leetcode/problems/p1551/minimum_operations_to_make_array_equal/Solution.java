package com.github.xtralife.leetcode.problems.p1551.minimum_operations_to_make_array_equal;

public class Solution {
    public int minOperations(int n) {
        return n % 2 == 0 ? (n / 2) * (n / 2) : (n / 2) * (n / 2 + 1);
    }
}
