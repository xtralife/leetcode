package com.github.xtralife.leetcode.problems.p31.next_permutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
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
                if (nums[second] > nums[first]) {
                    int temp = nums[second];
                    nums[second] = nums[first];
                    nums[first] = temp;
                    break;
                }
                second --;
            }
        }
        for (int i = 0; i < (nums.length - first - 1) / 2; i++) {
            int temp = nums[i + first + 1];
            nums[i + first + 1] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
