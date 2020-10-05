package com.github.xtralife.leetcode.problems.p297.serialize_and_deserialize_binary_tree.bfs_nonoptimal;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

// LTE on LeetCode
public class Codec {
    private static final char delimiter = '|';
    private static final String splitter = "\\|";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nodes = 1;
        while (!queue.isEmpty()) {
            boolean hasNodes = false;
            for (int i = 0; i < nodes; i++) {
                TreeNode node = queue.remove();
                if (node == null) {
                    queue.offer(null);
                    queue.offer(null);
                } else {
                    hasNodes = true;
                    builder.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                builder.append(delimiter);
            }
            if (hasNodes) {
                nodes <<= 1;
            } else {
                queue.clear();
            }
        }
        while (builder.length() > 0 && builder.charAt(builder.length() - 1) == delimiter) {
            builder.deleteCharAt(builder.length() - 1);
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] tokens = data.split(splitter);
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < tokens.length; i++) {
            TreeNode node = queue.remove();
            if (!tokens[i].isEmpty()) {
                node.left = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(node.left);
            } else {
                queue.offer(null);
            }
            if (i == tokens.length - 1) {
                continue;
            }
            if (!tokens[++i].isEmpty()) {
                node.right = new TreeNode(Integer.parseInt(tokens[i]));
                queue.offer(node.right);
            } else {
                queue.offer(null);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));