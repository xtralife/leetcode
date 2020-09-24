package com.github.xtralife.leetcode.problems.p206.reverse_linked_list.recursively;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(new ListNode(head.val), head.next);
    }

    private ListNode reverse(ListNode node, ListNode list) {
        if (list == null) {
            return node;
        }
        ListNode next = new ListNode(list.val);
        next.next = node;
        return reverse(next, list.next);
    }
}
