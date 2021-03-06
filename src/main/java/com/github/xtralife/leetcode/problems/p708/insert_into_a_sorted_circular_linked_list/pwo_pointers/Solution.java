package com.github.xtralife.leetcode.problems.p708.insert_into_a_sorted_circular_linked_list.pwo_pointers;

public class Solution {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node prev = head;
        Node curr = head.next;
        do {
            if (prev.val > curr.val && (insertVal <= curr.val || insertVal >= prev.val)
            || (prev.val <= insertVal && insertVal <= curr.val)) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            curr = curr.next;
            prev = prev.next;
        } while (prev != head);

        head.next = new Node(insertVal, head.next);
        return head;
    }
}
