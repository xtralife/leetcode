package com.github.xtralife.leetcode.problems.p138.copy_list_with_random_pointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        Node dummy = new Node(0);
        Node oldNode = head;
        Node newNode = dummy;
        Map<Node, Node> map = new HashMap<>();
        while (oldNode != null) {
            newNode.next = new Node(oldNode.val);
            map.put(oldNode, newNode.next);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        oldNode = head;
        newNode = dummy.next;
        while (oldNode != null) {
            newNode.random = map.get(oldNode.random);
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return dummy.next;
    }
}
