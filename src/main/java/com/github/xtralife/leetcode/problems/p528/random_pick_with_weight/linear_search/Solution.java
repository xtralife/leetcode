package com.github.xtralife.leetcode.problems.p528.random_pick_with_weight.linear_search;

import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    private final int[] ranges;
    private final int max;

    public Solution(int[] w) {
        ranges = new int[w.length];
        int upper = 0;
        for (int i = 0; i < w.length; i++) {
            upper += w[i];
            ranges[i] = upper;
        }
        max = upper;
    }

    public int pickIndex() {
        int random = ThreadLocalRandom.current().nextInt(max) + 1;
        int i = 0;
        while (ranges[i] < random) {
            i++;
        }
        return i;
    }
}
