package com.github.xtralife.leetcode.problems.p160.intersection_of_two_linked_lists;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = getLength(headA);
        int bLength = getLength(headB);
        ListNode longer = aLength < bLength ? headB : headA;
        ListNode shorter = aLength < bLength ? headA : headB;
        for (int i = 0; i < Math.abs(aLength - bLength); i++) {
            longer = longer.next;
        }
        while (longer != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }

    private int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
