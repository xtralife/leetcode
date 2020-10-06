package com.github.xtralife.leetcode.problems.p167.two_sum_ii_input_array_is_sorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int sum = numbers[start] + numbers[end];
        while (sum != target) {
            if (sum > target) {
                end--;
            } else {
                start++;
            }
            sum = numbers[start] + numbers[end];
        }
        return new int[]{start + 1, end + 1};
    }
}
