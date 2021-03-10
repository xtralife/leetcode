package com.github.xtralife.leetcode.problems.p340.longest_substring_with_at_most_k_distinct_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int count = 0;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            char ch = s.charAt(end++);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if (map.size() <= k) {
                continue;
            }
            count = Math.max(count, end - start - 1);
            while (map.size() > k) {
                ch = s.charAt(start++);
                map.put(ch, map.get(ch) - 1);
                map.remove(ch, 0);
            }
        }
        return Math.max(count, end - start);
    }
}
