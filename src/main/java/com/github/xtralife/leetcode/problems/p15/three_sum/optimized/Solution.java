package com.github.xtralife.leetcode.problems.p15.three_sum.optimized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            findPairs(nums, i, result);
        }
        return result;
    }

    private void findPairs(int[] nums, int index, List<List<Integer>> result) {
        int start = index + 1;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[index] + nums[start] + nums[end];
            if (sum == 0) {
                result.add(Arrays.asList(nums[index], nums[start++], nums[end--]));
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
            } else if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }
    }
}
