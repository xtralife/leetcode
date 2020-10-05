package com.github.xtralife.leetcode.problems.p215.kth_largest_element_in_an_array.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.remove();
        }
        return queue.remove();
    }
}
