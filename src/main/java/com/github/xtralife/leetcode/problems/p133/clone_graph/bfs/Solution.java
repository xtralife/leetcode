package com.github.xtralife.leetcode.problems.p133.clone_graph.bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> cloned = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node rootClone = new Node(node.val);
        cloned.put(node.val, rootClone);
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node currentClone = cloned.get(current.val);
            for (Node neighbor : current.neighbors) {
                if (!cloned.containsKey(neighbor.val)) {
                    Node neighborClone = new Node(neighbor.val);
                    cloned.put(neighbor.val, neighborClone);
                    queue.add(neighbor);
                }
                currentClone.neighbors.add(cloned.get(neighbor.val));
            }
        }
        return rootClone;
    }
}
