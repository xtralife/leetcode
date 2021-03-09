package com.github.xtralife.leetcode.problems.p236.lowest_common_ancestor_of_a_binary_tree.deque;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> pDeque = buildDeque(root, p);
        Deque<TreeNode> qDeque = buildDeque(root, q);
        TreeNode lca = root;
        while (pDeque.peekFirst() == qDeque.peekFirst()) {
            lca = pDeque.pollFirst();
            qDeque.pollFirst();
        }
        return lca;
    }

    private Deque<TreeNode> buildDeque(TreeNode root, TreeNode node) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        return buildDeque(deque, node);
    }

    private Deque<TreeNode> buildDeque(Deque<TreeNode> deque, TreeNode node) {
        TreeNode last = deque.peekLast();
        if (last == node) {
            return deque;
        }
        if (last.left != null) {
            deque.add(last.left);
            deque = buildDeque(deque, node);
            if (deque.peekLast() == node) {
                return deque;
            }
            deque.pollLast();
        }
        if (last.right != null) {
            deque.add(last.right);
            deque = buildDeque(deque, node);
            if (deque.peekLast() == node) {
                return deque;
            }
            deque.pollLast();
        }
        return deque;
    }
}
