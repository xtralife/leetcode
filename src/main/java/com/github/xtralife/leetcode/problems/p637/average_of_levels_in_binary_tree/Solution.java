package com.github.xtralife.leetcode.problems.p637.average_of_levels_in_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        assert root != null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Double> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(sum / levelSize);
        }
        return result;
    }
}
