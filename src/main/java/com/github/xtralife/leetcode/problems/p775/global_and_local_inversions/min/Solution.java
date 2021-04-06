package com.github.xtralife.leetcode.problems.p775.global_and_local_inversions.min;

public class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int min = n;
        for (int i = n - 1; i >= 2; i--) {
            min = Math.min(min, A[i]);
            if (A[i - 2] > min) {
                return false;
            }
        }
        return true;
    }
}
