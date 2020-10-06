package com.github.xtralife.leetcode.problems.p15.three_sum;

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

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            List<List<Integer>> pairs = findPairs(nums, i + 1, -nums[i]);
            if (pairs.size() > 0) {
                for (List<Integer> pair : pairs) {
                    result.add(Arrays.asList(nums[i], pair.get(0), pair.get(1)));
                }
                int num = nums[i];
                while (nums[i + 1] == num && i < nums.length - 3) {
                    i++;
                }
            }
        }
        return result;
    }

    private List<List<Integer>> findPairs(int[] nums, int index, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int start = index;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                int nOne = nums[start];
                int nTwo = nums[end];
                result.add(Arrays.asList(nOne, nTwo));
                while (nums[start] == nOne && start < end) {
                    start++;
                }
                while (nums[end] == nTwo && start < end) {
                    end--;
                }
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
