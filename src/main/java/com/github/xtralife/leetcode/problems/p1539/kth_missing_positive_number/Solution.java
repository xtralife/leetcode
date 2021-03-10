package com.github.xtralife.leetcode.problems.p1539.kth_missing_positive_number;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int curr = 1;
        int p = 0;
        int missed = 0;
        while (missed < k && p < arr.length) {
            if (curr == arr[p]) {
                curr++;
            } else {
                missed += arr[p] - curr;
                curr = arr[p] + 1;
            }
            p++;
        }
        if (p == arr.length) {
            missed++;
        }
        return curr - missed + k - 2;
    }
}
