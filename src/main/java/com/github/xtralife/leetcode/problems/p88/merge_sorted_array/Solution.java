package com.github.xtralife.leetcode.problems.p88.merge_sorted_array;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int resPointer = nums1.length - 1;
        int nums1Pointer = m - 1;
        int nums2Pointer = n - 1;
        while (nums2Pointer > -1) {
            if (nums1Pointer < 0 || nums1[nums1Pointer] <= nums2[nums2Pointer]) {
                nums1[resPointer--] = nums2[nums2Pointer--];
            } else {
                nums1[resPointer--] = nums1[nums1Pointer--];
            }
        }
    }
}