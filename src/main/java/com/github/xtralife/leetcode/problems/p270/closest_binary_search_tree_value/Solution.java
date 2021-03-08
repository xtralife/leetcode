package com.github.xtralife.leetcode.problems.p270.closest_binary_search_tree_value;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (target > root.val) {
            return findClosest(root.val, target, root.right);
        } else {
            return findClosest(root.val, target, root.left);
        }
    }

    private int findClosest(int val, double target, TreeNode node) {
        if (node == null) {
            return val;
        }
        if (Math.abs(val - target) < Math.abs(node.val) - target) {
            return val;
        }
        if (target > node.val) {
            return findClosest(node.val, target, node.right);
        } else {
            return findClosest(node.val, target, node.left);
        }
    }
}
