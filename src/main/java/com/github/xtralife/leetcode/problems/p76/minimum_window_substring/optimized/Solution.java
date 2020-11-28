package com.github.xtralife.leetcode.problems.p76.minimum_window_substring.optimized;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int tChars = tMap.size();

        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int sChars = 0;
        String result = "";
        int resLength = Integer.MAX_VALUE;
        while (end < s.length() || sChars == tChars) {
            if (sChars < tChars) {
                char ch = s.charAt(end++);
                if (!tMap.containsKey(ch)) {
                    continue;
                }
                sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
                if (sMap.get(ch).equals(tMap.get(ch))) {
                    sChars++;
                }
            } else {
                char ch = s.charAt(start++);
                if (sMap.containsKey(ch)) {
                    sMap.put(ch, sMap.get(ch) - 1);
                    if (tMap.get(ch) > sMap.get(ch)) {
                        sChars--;
                    }
                }
            }
            if (sChars == tChars && end - start < resLength) {
                resLength = end - start;
                result = s.substring(start, end);
            }
        }
        return result;
    }
}
