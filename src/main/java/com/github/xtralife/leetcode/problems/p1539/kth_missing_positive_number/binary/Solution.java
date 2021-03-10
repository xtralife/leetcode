package com.github.xtralife.leetcode.problems.p1539.kth_missing_positive_number.binary;

public class Solution {
    public int findKthPositive(int[] arr, int k) {
        if (arr[0] > k) {
            return k;
        }
        if (arr[arr.length - 1] - arr.length < k ) {
            return k + arr.length;
        }
        int start = 0;
        int end = arr.length - 1;
        return findKthPositive(arr, k, start, end);
    }

    private int findKthPositive(int[] arr, int k, int start, int end) {
        if (start + 1 == end) {
            return k + end;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] - mid - 1 < k) {
            return findKthPositive(arr, k, mid, end);
        } else {
            return findKthPositive(arr, k, start, mid);
        }
    }
}
