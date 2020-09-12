package com.github.xtralife.leetcode.problems.p189.rotate_array;

class Solution {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k == 0 || k % length == 0) {
            return;
        }
        k = k % length;
        int count = 0;
        int cachedIndex = 0;
        int cachedValue = nums[cachedIndex];
        int currentIndex = cachedIndex;

        while (count < length) {
            int sourceIndex = currentIndex - k < 0 ? currentIndex - k + length : currentIndex - k;
            if (sourceIndex == cachedIndex) {
                nums[currentIndex] = cachedValue;
                cachedIndex++;
                cachedValue = nums[cachedIndex];
                currentIndex = cachedIndex;
            } else {
                nums[currentIndex] = nums[sourceIndex];
                currentIndex = sourceIndex;
            }
            count++;
        }
    }
}
