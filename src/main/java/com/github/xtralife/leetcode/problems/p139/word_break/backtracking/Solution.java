package com.github.xtralife.leetcode.problems.p139.word_break.backtracking;

import java.util.List;

//LTE on LeetCode
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return canBreak(s, 0, wordDict);
    }

    private boolean canBreak(String s, int pointer, List<String> words) {
        if (pointer == s.length()) {
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = pointer; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (words.contains(sb.toString())) {
                if (canBreak(s, i + 1, words)) {
                    return true;
                }
            }
        }
        return false;
    }
}
