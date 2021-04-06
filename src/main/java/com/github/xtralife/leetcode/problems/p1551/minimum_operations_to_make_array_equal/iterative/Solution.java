package com.github.xtralife.leetcode.problems.p1551.minimum_operations_to_make_array_equal.iterative;

public class Solution {
    public int minOperations(int n) {
        int res = 0;
        while (n > 0) {
            res += n - 1;
            n -=2;
        }
        return res;
    }
}
