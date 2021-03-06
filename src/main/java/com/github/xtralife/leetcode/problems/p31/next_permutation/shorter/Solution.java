package com.github.xtralife.leetcode.problems.p31.next_permutation.shorter;

public class Solution {
    public void nextPermutation(int[] nums) {
        int first = nums.length - 2;
        while (first >= 0) {
            if (nums[first] < nums[first + 1]) {
                break;
            }
            first--;
        }
        if (first >= 0) {
            int second = nums.length - 1;
            while (second > first) {
                if (nums[first] < nums[second]) {
                    swap(nums, first, second);
                    break;
                }
                second--;
            }
        }
        reverse(nums, first + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
