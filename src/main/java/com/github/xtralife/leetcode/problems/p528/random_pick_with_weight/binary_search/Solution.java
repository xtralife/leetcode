package com.github.xtralife.leetcode.problems.p528.random_pick_with_weight.binary_search;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    private final int[] ranges;
    private final int max;

    public Solution(int[] w) {
        ranges = new int[w.length];
        int higher = 0;
        for (int i = 0; i < w.length; i++) {
            higher += w[i];
            ranges[i] = higher;
        }
        max = higher;
    }

    public int pickIndex() {
        int random = ThreadLocalRandom.current().nextInt(max) + 1;
        int low = 0;
        int high = ranges.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ranges[mid] < random) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
