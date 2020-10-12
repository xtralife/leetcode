package com.github.xtralife.leetcode.problems.p23.merge_k_sorted_list.divide_and_conquer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode node : lists) {
            queue.offer(node);
        }
        while (queue.size() > 1) {
            queue.add(merge(queue.poll(), queue.poll()));
        }
        return queue.poll();
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (one != null && two != null) {
            if (one.val <= two.val) {
                curr.next = one;
                curr = one;
                one = one.next;
            } else {
                curr.next = two;
                curr = two;
                two = two.next;
            }
        }
        if (one == null) {
            curr.next = two;
        } else {
            curr.next = one;
        }
        return dummy.next;
    }
}
