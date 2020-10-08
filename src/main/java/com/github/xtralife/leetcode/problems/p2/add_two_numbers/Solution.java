package com.github.xtralife.leetcode.problems.p2.add_two_numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int val = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            prev.next = new ListNode(val);
            prev = prev.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            prev.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
