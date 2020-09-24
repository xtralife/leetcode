package com.github.xtralife.leetcode.problems.p242.valid_anagram;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (char c : s.toCharArray()) {
            occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            Integer count = occurrences.get(c);
            if (count == null || count < 1) {
                return false;
            }
            occurrences.put(c, count - 1);
        }
        for (Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }
}
