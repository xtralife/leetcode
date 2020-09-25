package com.github.xtralife.leetcode.problems.p101.symmetric_tree.iteratively;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);

        while (!deque.isEmpty()) {
            TreeNode head = deque.pollFirst();
            TreeNode tail = deque.pollLast();
            if (head == null && tail == null) {
                continue;
            }
            if (head == null || tail == null) {
                return false;
            }
            if (head.val != tail.val) {
                return false;
            }
            deque.offerFirst(head.right);
            deque.offerFirst(head.left);
            deque.offerLast(tail.left);
            deque.offerLast(tail.right);
        }
        return true;
    }
}
