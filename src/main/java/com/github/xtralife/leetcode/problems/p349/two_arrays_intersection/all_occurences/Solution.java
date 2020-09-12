package com.github.xtralife.leetcode.problems.p349.two_arrays_intersection.all_occurences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int num : nums1) {
            numsMap.put(num, numsMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            int count = numsMap.getOrDefault(num, 0);
            if (count > 0) {
                result.add(num);
                numsMap.put(num, count - 1);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}