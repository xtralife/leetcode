package com.github.xtralife.leetcode.problems.p349.two_arrays_intersection.unique_occurences.approach1;

import java.util.*;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
                set.remove(num);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}