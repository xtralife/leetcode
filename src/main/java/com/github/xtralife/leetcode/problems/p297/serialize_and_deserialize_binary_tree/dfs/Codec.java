package com.github.xtralife.leetcode.problems.p297.serialize_and_deserialize_binary_tree.dfs;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final char delimiter = '|';
    private static final String splitter = "\\|";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        dfsSerialize(root, builder);
        return builder.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append(delimiter);
            return;
        }
        builder.append(node.val);
        builder.append(delimiter);
        dfsSerialize(node.left, builder);
        dfsSerialize(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] tokens = data.split(splitter);
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        int[] index = new int[1];
        index[0] = 1;
        dfsDeserialize(root, tokens, index);
        return root;
    }

    private void dfsDeserialize(TreeNode node, String[] tokens, int[] index) {
        if (index[0] == tokens.length) {
            return;
        }
        if (!tokens[index[0]].isEmpty()) {
            node.left = new TreeNode(Integer.parseInt(tokens[index[0]++]));
            dfsDeserialize(node.left, tokens, index);
        } else {
            index[0]++;
        }
        if (index[0] == tokens.length) {
            return;
        }
        if (!tokens[index[0]].isEmpty()) {
            node.right = new TreeNode(Integer.parseInt(tokens[index[0]++]));
            dfsDeserialize(node.right, tokens, index);
        } else {
            index[0]++;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));