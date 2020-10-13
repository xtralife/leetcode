package com.github.xtralife.leetcode.problems.p39.combination_sum.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<Integer>> combinations;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinations = new ArrayList<>();
        List<Integer> currCombination = new ArrayList<>();
        findCombinations(candidates, 0, target, currCombination, 0);
        return combinations;
    }

    private void findCombinations(int[] nums, int start, int target, List<Integer> combination, int sum) {
        for (int i = start; i < nums.length; i++) {
            int value = nums[i];
            if (sum + value == target) {
                List<Integer> result = new ArrayList<>(combination);
                result.add(value);
                combinations.add(result);
                continue;
            }
            if (sum + value < target) {
                combination.add(value);
                findCombinations(nums, i, target, combination, sum + value);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
