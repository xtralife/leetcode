package com.github.xtralife.leetcode.problems.p270.closest_binary_search_tree_value.inorder;

import java.util.Stack;

public class Solution {
    public int closestValue(TreeNode root, double target) {
        long closest = Long.MIN_VALUE;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (target >= closest && target <= node.val) {
                return Math.abs(target - closest) < Math.abs(target - node.val) ? (int) closest : node.val;
            }
            closest = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return (int) closest;
    }
}
