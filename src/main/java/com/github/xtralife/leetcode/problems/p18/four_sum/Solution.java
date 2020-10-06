package com.github.xtralife.leetcode.problems.p18.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            findThree(nums, i, target, result);
        }
        return result;
    }

    private void findThree(int[] nums, int index, int target, List<List<Integer>> result) {
        for (int i = index + 1; i < nums.length - 2; i++) {
            if (i > index + 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            findTwo(nums, index, i, target, result);
        }
    }

    private void findTwo(int[] nums, int firstIndex, int secondIndex, int target, List<List<Integer>> result) {
        int twoTarget = target - nums[firstIndex] - nums[secondIndex];
        int start = secondIndex + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == twoTarget) {
                result.add(Arrays.asList(nums[firstIndex], nums[secondIndex], nums[start++], nums[end--]));
                while (start < end && nums[start - 1] == nums[start]) {
                    start++;
                }
            } else if (sum > twoTarget) {
                end--;
            } else {
                start++;
            }
        }
    }
}
