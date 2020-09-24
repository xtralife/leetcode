package com.github.xtralife.leetcode.problems.p206.reverse_linked_list.iteratively;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = result;
            result = current;
            current = temp;
        }
        return result;
    }
}
