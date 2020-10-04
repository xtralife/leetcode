package com.github.xtralife.leetcode.problems.p140.word_break_ii.naive_recursion;

import java.util.*;

// LTE on LeetCode
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        return wordBreak(s, 0, words);
    }

    private List<String> wordBreak(String s, int pointer, Set<String> words) {
        if (pointer == s.length()) {
            return Collections.singletonList("");
        }
        List<String> result = new ArrayList<>();
        for (int i = pointer + 1; i <= s.length(); i++) {
            String word = s.substring(pointer, i);
            if (!words.contains(word)) {
                continue;
            }
            List<String> sentences = wordBreak(s, i, words);
            if (sentences.isEmpty()) {
                continue;
            }
            sentences.forEach(sentence -> result.add(sentence.isEmpty() ? word : word + " " + sentence));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> result = solution.wordBreak("catsanddog", dict);
        System.out.println(result);
    }
}
