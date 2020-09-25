package com.github.xtralife.leetcode.problems.p102.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        return levelOrder(result, queue);
    }

    private List<List<Integer>> levelOrder(List<List<Integer>> result, Queue<TreeNode> queue) {
        List<Integer> row = new ArrayList<>();
        for (TreeNode node = queue.poll(); node != null; node = queue.poll()) {
            row.add(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        result.add(row);
        if (queue.isEmpty()) {
            return result;
        }

        queue.offer(null);
        return levelOrder(result, queue);
    }
}
