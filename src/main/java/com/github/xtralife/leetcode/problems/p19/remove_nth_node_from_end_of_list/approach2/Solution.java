package com.github.xtralife.leetcode.problems.p19.remove_nth_node_from_end_of_list.approach2;

/*
   [1, 2, 3, 4, 5]

   [d, 1, 2, 3, 4, 5]
t:                    ^
h:           ^
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode t = head;
        for (int i = 0; i < n; i++) {
            t = t.next;
        }
        ListNode h = dummy;
        while (t != null) {
            h = h.next;
            t = t.next;
        }
        h.next = h.next.next;
        return dummy.next;
    }
}
