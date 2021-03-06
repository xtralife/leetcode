package com.github.xtralife.leetcode.problems.p820.short_encoding_of_words;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children = new HashMap<>();
    public int depth;

    public TrieNode(int depth) {
        this.depth = depth;
    }
}
