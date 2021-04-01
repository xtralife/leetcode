package com.github.xtralife.leetcode.problems.p234.palindrome_linked_list.stack;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = getMiddle(head);
        ListNode rest = reverseList(middle.next);
        ListNode start = head;
        ListNode end = rest;
        while (end != null) {
            if (end.val != start.val) {
                return false;
            }
            start = start.next;
            end = end.next;
        }
        middle.next = reverseList(rest);
        return true;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
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
