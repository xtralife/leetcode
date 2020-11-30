package com.github.xtralife.leetcode.problems.p139.word_break.dp_memo;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] memo = new boolean[length + 1];
        memo[0] = true;
        for (int start = 0; start < length; start++) {
            if (!memo[start]) {
                continue;
            }
            for (int end = start + 1; end <= length; end++) {
                if (memo[end]) {
                    continue;
                }
                if (wordDict.contains(s.substring(start, end))) {
                    memo[end] = true;
                }
            }
        }
        return memo[length];
    }
}
