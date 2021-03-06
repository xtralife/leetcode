package com.github.xtralife.leetcode.problems.p820.short_encoding_of_words;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode(1);
        for (String word : words) {
            TrieNode currNode = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!currNode.children.containsKey(ch)) {
                    currNode.children.put(ch, new TrieNode(currNode.depth + 1));
                }
                currNode = currNode.children.get(ch);
            }
        }
        int result = 0;
        Queue<TrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();
            if (node.children.isEmpty()) {
                result += node.depth;
            }
            queue.addAll(node.children.values());
        }
        return result;
    }
}
