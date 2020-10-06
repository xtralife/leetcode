package com.github.xtralife.leetcode.problems.p528.random_pick_with_weight.binary_tree;

import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    private final NavigableMap<Integer, Integer> ranges = new TreeMap<>();
    private final int max;

    public Solution(int[] w) {
        int lower = 0;
        for (int i = 0; i < w.length; i++) {
            ranges.put(lower, i);
            lower += w[i];
        }
        max = lower;
    }

    public int pickIndex() {
        int random = ThreadLocalRandom.current().nextInt(max);
        return ranges.floorEntry(random).getValue();
    }
}
