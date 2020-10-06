package com.github.xtralife.algorithms.quicksort.hoare;

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
        int pivot = nums[start + (end - start) / 2];
        int i = start;
        int j = end;
        while (true) {
            while (nums[i] < pivot) {
                i++;
            }
            while (nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
