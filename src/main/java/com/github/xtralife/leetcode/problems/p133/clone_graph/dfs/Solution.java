package com.github.xtralife.leetcode.problems.p133.clone_graph.dfs;

import com.github.xtralife.leetcode.problems.p133.clone_graph.bfs.Node;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> cloned = new HashMap<>();
        return doClone(node, cloned);
    }

    private Node doClone(Node node, Map<Integer, Node> cloned) {
        int val = node.val;
        Node clone;
        if (cloned.containsKey(val)) {
            clone = cloned.get(val);
        } else {
            clone = new Node(node.val);
            cloned.put(node.val, clone);
            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(doClone(neighbor, cloned));
            }
        }
        return clone;
    }
}
