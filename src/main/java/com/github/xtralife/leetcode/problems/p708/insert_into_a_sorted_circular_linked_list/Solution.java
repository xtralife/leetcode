package com.github.xtralife.leetcode.problems.p708.insert_into_a_sorted_circular_linked_list;

public class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            node.next = node;
            return node;
        }
        if (isPlain(head)) {
            node.next = head.next;
            head.next = node;
            return node;
        }
        Node curr = head;
        while (true) {
            if ((curr.val > curr.next.val && (curr.val <= insertVal || curr.next.val >= insertVal))
                    || (curr.val <= insertVal && curr.next.val >= insertVal)) {
                node.next = curr.next;
                curr.next = node;
                break;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    private boolean isPlain(Node head) {
        Node curr = head.next;
        while (curr != head) {
            if (curr.val != curr.next.val) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}
