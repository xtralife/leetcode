package com.github.xtralife.leetcode.problems.p285.inorder_successor_in_bst.iterative_inorder;

import java.util.Stack;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        var stack = new Stack<TreeNode>();
        boolean doReturn = false;
        var current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (doReturn) return current;
            if (current.equals(p)) doReturn = true;
            current = current.right;
        }
        return null;
    }
}

