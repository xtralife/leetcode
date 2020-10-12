package com.github.xtralife.leetcode.problems.p33.search_in_rotated_sorted_array.two_pass;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int rotatePoint = getRotatePoint(nums);
        if (rotatePoint == 0 || target < nums[0]) {
            return binarySearch(nums, rotatePoint, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, rotatePoint - 1, target);
        }
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] == target) {
            return start;
        }
        return -1;
    }

    private int getRotatePoint(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] <= nums[end]) {
            return 0;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }
            if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}