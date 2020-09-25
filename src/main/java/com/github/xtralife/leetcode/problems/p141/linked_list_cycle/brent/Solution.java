package com.github.xtralife.leetcode.problems.p141.linked_list_cycle.brent;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;

        int taken = 0;
        int limit = 2;

        while (fast.next != null) {
            fast = fast.next;
            taken++;
            if (slow == fast) {
                return true;
            }
            if (taken == limit) {
                limit <<= 1;
                taken = 0;
                slow = fast;
            }
        }
        return false;
    }
}