package com.github.xtralife.leetcode.problems.p973.k_closest_points_to_origin.quicksort;

import java.util.Arrays;

public class Solution {private int[][] points;

    public int[][] kClosest(int[][] points, int k) {
        this.points = points;
        quicksort(0, points.length - 1, k);
        return Arrays.copyOfRange(points, 0, k);
    }

    private void quicksort(int start, int end, int K) {
        if (start > end) {
            return;
        }
        int partition = partition(start, end);
        if (K > partition) {
            quicksort(partition + 1, end, K);
        }
        if (K < partition) {
            quicksort(start, partition - 1, K);
        }
    }

    private int partition(int start, int end) {
        int pivot = dist(points[end]);
        int pointer = start;
        for (int i = start; i < end; i++) {
            if (dist(points[i]) < pivot) {
                swap(points[i], points[pointer]);
                pointer++;
            }
        }
        swap(points[end], points[pointer]);
        return pointer;
    }

    private void swap(int[] one, int[] second) {
        int temp = one[0];
        one[0] = second[0];
        second[0] = temp;
        temp = one[1];
        one[1] = second[1];
        second[1] = temp;
    }

    private int dist(int[] pointer) {
        return pointer[0] * pointer[0] + pointer[1] * pointer[1];
    }
}
