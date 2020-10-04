package com.github.xtralife.leetcode.problems.p199.binary_tree_right_side_view.bfs_right;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> see = new ArrayList<>();
        if (root == null) {
            return see;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (!queue.isEmpty()) {
            int levelCount = 0;
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.remove();
                if (i == 0) {
                    see.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    levelCount++;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    levelCount++;
                }
            }
            count = levelCount;
        }
        return see;
    }
}
