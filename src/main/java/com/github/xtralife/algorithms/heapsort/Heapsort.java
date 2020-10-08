package com.github.xtralife.algorithms.heapsort;

public class Heapsort {
    public static int[] sort(int[] nums) {
        buildMaxHeap(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            maxHeapify(nums, i, 0);
        }
        return nums;
    }

    private static void maxHeapify(int[] nums, int size, int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int max = index;

        if (left < size && nums[left] > nums[max]) {
            max = left;
        }
        if (right < size && nums[right] > nums[max]) {
            max = right;
        }
        if (max != index) {
            int temp = nums[max];
            nums[max] = nums[index];
            nums[index] = temp;
            maxHeapify(nums, size, max);
        }
    }

    private static void buildMaxHeap(int[] nums) {
        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            maxHeapify(nums, length, i);
        }
    }
}
