package com.github.xtralife.leetcode.problems.p384.shuffle_an_array;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {
    private final int[] nums;
    private final int length;

    public Solution(int[] nums) {
        this.nums = nums;
        this.length = nums.length;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(nums, length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] shuffled = Arrays.copyOf(nums, length);
        for (int i = length; i > 0; i--) {
            int j = ThreadLocalRandom.current().nextInt(i);
            int temp = shuffled[j];
            shuffled[j] = shuffled[i - 1];
            shuffled[i - 1] = temp;
        }
        return shuffled;
    }
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
