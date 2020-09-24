package com.github.xtralife.leetcode.problems.p19.remove_nth_node_from_end_of_list;
/*
5
    [1, 2, 3, 4, 5]
                    ^

    [1, 2, 3, 4, 5]
t:               ^
h:         ^
h.next = h.next.next

until t.next == null
n times
  2

*/
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode tail = head;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        if (tail == null) {
            return head.next;
        }
        ListNode nth = head;
        while (tail.next != null) {
            tail = tail.next;
            nth = nth.next;
        }
        nth.next = nth.next.next;
        return head;
    }
}