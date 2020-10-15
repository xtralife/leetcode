package com.github.xtralife.leetcode.problems.p103.binary_tree_zigzag_level_order_traversal;

import org.testng.annotations.Test;

import java.util.List;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        assert result.size() == 3;
    }
}
