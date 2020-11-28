package com.github.xtralife.leetcode.problems.p76.minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0;
        int end = 1;
        String result = "";
        int resLength = Integer.MAX_VALUE;
        sMap.put(s.charAt(start), 1);
        while (start < end) {
            if (containsAll(sMap, tMap)) {
                if (end - start < resLength) {
                    resLength = end - start;
                    result = s.substring(start, end);
                }
                int charCount = sMap.get(s.charAt(start));
                if (charCount == 1) {
                    sMap.remove(s.charAt(start));
                } else {
                    sMap.put(s.charAt(start), --charCount);
                }
                start++;
            } else if (end == s.length()) {
                return result;
            } else {
                sMap.put(s.charAt(end), sMap.getOrDefault(s.charAt(end), 0) + 1);
                end++;
            }
        }
        return result;
    }

    private boolean containsAll(Map<Character, Integer> s, Map<Character, Integer> t) {
        if (!s.keySet().containsAll(t.keySet())) {
            return false;
        }
        for (Map.Entry<Character, Integer> tCh : t.entrySet()) {
            if (s.get(tCh.getKey()) < tCh.getValue()) {
                return false;
            }
        }
        return true;
    }
}
