package com.github.xtralife.algorithms.quicksort.lomuto;

public class Quicksort {
    public static int[] quicksort(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quicksort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int partition = partition(nums, start, end);
        quicksort(nums, start, partition - 1);
        quicksort(nums, partition + 1, end);
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (nums[i] < pivot) {
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }
        int temp = nums[pointer];
        nums[pointer] = nums[end];
        nums[end] = temp;
        return pointer;
    }
}
