package com.github.xtralife.leetcode.problems.p98.validate_binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        Queue<TreeNode> sequence = new LinkedList<>();
        fillQueue(sequence, root);
        for (TreeNode current = sequence.poll(); current != null; current = sequence.poll()) {
            if (sequence.peek() != null && sequence.peek().val <= current.val) {
                return false;
            }
        }
        return true;
    }

    private void fillQueue(Queue<TreeNode> sequence, TreeNode root) {
        if (root == null) {
            return;
        }
        fillQueue(sequence, root.left);
        sequence.offer(root);
        fillQueue(sequence, root.right);
    }
}