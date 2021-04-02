package com.github.xtralife.leetcode.problems.p1133.largest_unique_number;

import java.util.TreeMap;

public class Solution {
    public int largestUniqueNumber(int[] A) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : map.descendingKeySet()) {
            if (map.get(i) == 1) {
                return i;
            }
        }
        return -1;
    }
}
