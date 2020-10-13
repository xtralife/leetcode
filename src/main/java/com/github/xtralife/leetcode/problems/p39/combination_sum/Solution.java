package com.github.xtralife.leetcode.problems.p39.combination_sum;

import java.util.*;

public class Solution {
    private final Map<Integer, Set<Map<Integer, Integer>>> memo = new HashMap<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        calcCombinationSum(candidates, target);
        return convert(memo.get(target));
    }

    private List<List<Integer>> convert(Set<Map<Integer, Integer>> combinations) {
        List<List<Integer>> result = new ArrayList<>();
        combinations.forEach(combination -> result.add(convert(combination)));
        return result;
    }

    private List<Integer> convert(Map<Integer, Integer> combination) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : combination.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    private void calcCombinationSum(int[] nums, int target) {
        if (target < 1) {
            return;
        }
        if (memo.containsKey(target)) {
            return;
        }
        memo.put(target, new HashSet<>());
        for (int num : nums) {
            if (num > target) {
                continue;
            }
            if (num == target) {
                Map<Integer, Integer> itself = new HashMap<>();
                itself.put(num, 1);
                memo.get(target).add(itself);
                continue;
            }
            calcCombinationSum(nums, target - num);
            for (Map<Integer, Integer> map : memo.get(target - num)) {
                Map<Integer, Integer> itself = new HashMap<>(map);
                itself.put(num, itself.getOrDefault(num, 0) + 1);
                memo.get(target).add(itself);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(result);
    }
}
