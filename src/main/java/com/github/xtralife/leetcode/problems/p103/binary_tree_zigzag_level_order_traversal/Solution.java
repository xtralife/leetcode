package com.github.xtralife.leetcode.problems.p103.binary_tree_zigzag_level_order_traversal;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        boolean toLeft = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (toLeft) {
                    TreeNode node = deque.poll();
                    level.add(node.val);
                    if (node.right != null) {
                        deque.offer(node.right);
                    }
                    if (node.left != null) {
                        deque.offer(node.left);
                    }
                } else {
                    TreeNode node = deque.pollLast();
                    level.add(node.val);
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                }
            }
            result.add(level);
            toLeft = !toLeft;
        }
        return result;
    }
}
