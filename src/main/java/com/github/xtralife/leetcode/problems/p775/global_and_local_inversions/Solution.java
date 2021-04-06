package com.github.xtralife.leetcode.problems.p775.global_and_local_inversions;

public class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == i) {
                continue;
            }
            if (A[i] == i + 1 && A[i + 1] == i) {
                i++;
                continue;
            }
            return false;
        }
        return true;
    }
}
