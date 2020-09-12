package com.github.xtralife.leetcode.problems.p349.two_arrays_intersection.unique_occurences.approach2;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(i -> i).toArray();
    }
}