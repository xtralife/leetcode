package com.github.xtralife.leetcode.problems.p33.search_in_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {
        return rotatedBinarySearch(nums, 0, nums.length - 1, target);
    }

    private int rotatedBinarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            }
            if (nums[start] <= midNum) { //rotate point is between mid and end
                if (nums[start] <= target && target < midNum) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (midNum < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
