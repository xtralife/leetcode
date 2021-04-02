package com.github.xtralife.leetcode.problems.p46.permutations.lexicographical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean hasNext = true;
        while (hasNext) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            hasNext = false;
            int first = 0;
            int second = 0;
            for (int i = nums.length - 1; i > 0; i--) {
                if (nums[i] > nums[i - 1]) {
                    hasNext = true;
                    first = i - 1;
                    break;
                }
            }
            for (int i = nums.length - 1; i > first; i--) {
                if (nums[i] > nums[first]) {
                    second = i;
                    break;
                }
            }
            swap(nums, first, second);
            reverse(nums, first + 1);
        }
        return result;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
