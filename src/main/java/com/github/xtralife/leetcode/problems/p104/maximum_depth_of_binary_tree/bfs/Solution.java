package com.github.xtralife.leetcode.problems.p104.maximum_depth_of_binary_tree.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Pair {
        TreeNode node;
        Integer depth;

        public Pair(TreeNode node, Integer depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int depth = 0;
        for (Pair pair = queue.poll(); pair != null; ) {
            if (pair.node.left != null) {
                queue.offer(new Pair(pair.node.left, pair.depth + 1));
            }
            if (pair.node.right != null) {
                queue.offer(new Pair(pair.node.right, pair.depth + 1));
            }
            if (depth < pair.depth) {
                depth = pair.depth;
            }
            pair = queue.poll();
        }
        return depth;
    }
}