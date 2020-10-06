package com.github.xtralife.leetcode.problems.p18.four_sum.generalized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, target, 4);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int numCount) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < numCount) {
            return result;
        }

        Arrays.sort(nums);

        return nSum(nums, target, numCount, 0);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int numCount, int index) {
        if (numCount == 2) {
            return twoSum(nums, target, index);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = index; i < nums.length - numCount + 1; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> prevSums = nSum(nums, target - nums[i], numCount - 1, i + 1);
            for (List<Integer> prevSum : prevSums) {
                List<Integer> sum = new ArrayList<>();
                sum.add(nums[i]);
                sum.addAll(prevSum);
                result.add(sum);
            }
        }
        return result;
    }

    private List<List<Integer>> twoSum(int[] nums, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();
        int start = index;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum == target) {
                result.add(Arrays.asList(nums[start++], nums[end--]));
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
