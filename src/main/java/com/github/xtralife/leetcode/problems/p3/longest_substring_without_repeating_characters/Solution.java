package com.github.xtralife.leetcode.problems.p3.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> chars = new HashMap<>();
        chars.put(s.charAt(0), 0);
        int maxSequence = 0;
        int seqStart = 0;
        for (int i = 1; i < s.length(); i++) {
            if (chars.containsKey(s.charAt(i))) {
                maxSequence = Math.max(maxSequence, i - seqStart);
                int lastSeen = chars.get(s.charAt(i));
                while (seqStart <= lastSeen) {
                    chars.remove(s.charAt(seqStart++));
                }
            }
            chars.put(s.charAt(i), i);
        }
        return Math.max(maxSequence, s.length() - seqStart);
    }
}
