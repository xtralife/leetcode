package com.github.xtralife.leetcode.problems.p211.design_add_and_search_words_data_structure.reversed_index;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class WordDictionary {
    private int count = 0;
    private final Map<Integer, SortedSet<Integer>> wordLengths = new HashMap<>();
    // 13201
    // 13 - character
    //   201 - position
    private final Map<Integer, SortedSet<Integer>> occurrences = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        wordLengths.putIfAbsent(word.length(), new TreeSet<>());
        wordLengths.get(word.length()).add(count);
        for (int i = 0; i < word.length(); i++) {
            int key = (word.charAt(i) - 'a') * 1000 + i;
            occurrences.putIfAbsent(key, new TreeSet<>());
            occurrences.get(key).add(count);
        }
        count++;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        wordLengths.putIfAbsent(word.length(), new TreeSet<>());
        SortedSet<Integer> foundWords = new TreeSet<>(wordLengths.get(word.length()));
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                continue;
            }
            int key = (ch - 'a') * 1000 + i;
            occurrences.putIfAbsent(key, new TreeSet<>());
            SortedSet<Integer> words = occurrences.get(key);
            foundWords.retainAll(words);
            if (foundWords.isEmpty()) {
                return false;
            }
        }
        return !foundWords.isEmpty();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */