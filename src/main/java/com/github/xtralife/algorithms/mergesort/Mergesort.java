package com.github.xtralife.algorithms.mergesort;

public class Mergesort {
    public static int[] sort(int[] nums) {
        mergeSort(nums, new int[nums.length], 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int[] temp, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = start + (end - start) / 2;
        mergeSort(nums, temp, start, middle);
        mergeSort(nums, temp, middle + 1, end);
        mergeHalves(nums, temp, start, end);
    }

    private static void mergeHalves(int[] nums, int[] temp, int leftStart, int rightEnd) {
        int size = rightEnd - leftStart + 1;
        int leftEnd = leftStart + (rightEnd - leftStart) / 2;
        int rightStart = leftEnd + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (nums[left] <= nums[right]) {
                temp[index++] = nums[left++];
            } else {
                temp[index++] = nums[right++];
            }
        }
        System.arraycopy(nums, left, temp, index, leftEnd - left + 1);
        System.arraycopy(nums, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, nums, leftStart, size);
    }
}
