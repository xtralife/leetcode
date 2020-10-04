package com.github.xtralife.leetcode.problems.p199.binary_tree_right_side_view.dfs_right;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> see = new ArrayList<>();
        dfs(root, see, 0);

        return see;
    }

    private void dfs(TreeNode node, List<Integer> see, int level) {
        if (node == null) {
            return;
        }

        if (see.size() == level) {
            see.add(node.val);
        }
        dfs(node.right, see, level + 1);
        dfs(node.left, see, level + 1);
    }
}
