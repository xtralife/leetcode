package com.github.xtralife.leetcode.problems.p211.design_add_and_search_words_data_structure.trie;

import java.util.*;

public class WordDictionary {
    static class TrieNode {
        Character value;
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {
        }

        public TrieNode(Character value) {
            this.value = value;
        }
    }

    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        TrieNode currentNode = root;
        for (char ch : word.toCharArray()) {
            if (!currentNode.children.containsKey(ch)) {
                TrieNode nextNode = new TrieNode(ch);
                currentNode.children.put(ch, nextNode);
            }
            currentNode = currentNode.children.get(ch);
        }
        currentNode.isWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode node) {
        TrieNode currentNode = node;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (currentNode.children.containsKey(ch)) {
                currentNode = currentNode.children.get(ch);
                continue;
            }
            if (ch == '.') {
                for (char key : currentNode.children.keySet()) {
                    if (search(word.substring(i + 1), currentNode.children.get(key))) {
                        return true;
                    }
                }
            }
            return false;
        }
        return currentNode.isWord;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */