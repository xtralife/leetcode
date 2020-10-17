package com.github.xtralife.leetcode.problems.p138.copy_list_with_random_pointer.recursive;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(0);
        Node oldDummy = new Node(0);
        oldDummy.next = head;
        copy(oldDummy, dummy, new HashMap<>());
        return dummy.next;
    }

    private void copy(Node src, Node dst, Map<Node, Node> visited) {
        if (visited.containsKey(src.next)) {
            dst.next = visited.get(src.next);
        } else if (src.next != null) {
            dst.next = new Node(src.next.val);
            visited.put(src.next, dst.next);
            copy(src.next, dst.next, visited);
        }
        if (visited.containsKey(src.random)) {
            dst.random = visited.get(src.random);
        } else if (src.random != null) {
            dst.random = new Node(src.random.val);
            visited.put(src.random, dst.random);
            copy(src.next, dst.next, visited);
        }
    }
}
