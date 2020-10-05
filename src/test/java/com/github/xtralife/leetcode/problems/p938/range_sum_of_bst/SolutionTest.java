package com.github.xtralife.leetcode.problems.p938.range_sum_of_bst;

import org.testng.annotations.Test;

public class SolutionTest {
    @Test
    public void testSolution() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18)));
        assert solution.rangeSumBST(root, 7, 15) == 32;
    }
}
