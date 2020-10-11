package com.github.xtralife.leetcode.problems.p538.binary_search_tree_to_greater_sum_tree;

/*
      4(30)
    /   \
   1(36)  6(21)
  / \(35)/  \
 0(36)2 5(26)7(15)
      \       \
       3(33)   8(8)

       4
    /    \
   1      6
  / \    /  \
 0   2   5   7
      \       \
       3       8(8)

4, 0
6, 0
7, 0
8, 0

 */
public class Solution {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    private int dfs(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        int rightSum = dfs(node.right, sum);
        node.val += rightSum;
        return dfs(node.left, node.val);
    }
}
