package com.github.xtralife.leetcode.problems.p23.merge_k_sorted_list;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
[1,4,5] [1,3,4] [2,6]
q: 4, 3, 6
d: 0, 1, 1, 2
l: 1
n: 2
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode dummy = new ListNode(0);
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode last = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (node.next != null) {
                queue.add(node.next);
            }
            last.next = node;
            last = node;
        }
        return dummy.next;
    }
}
