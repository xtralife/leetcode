package com.github.xtralife.leetcode.problems.p141.linked_list_cycle;

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode stub = new ListNode(Integer.MIN_VALUE);
        ListNode current = head;
        while (current != null) {
            if (current == stub) {
                return true;
            }
            ListNode temp = current.next;
            current.next = stub;
            current = temp;
        }
        return false;
    }
}