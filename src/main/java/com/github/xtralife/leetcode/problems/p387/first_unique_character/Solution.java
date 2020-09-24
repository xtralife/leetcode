package com.github.xtralife.leetcode.problems.p387.first_unique_character;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for (char c: s.toCharArray())
        {
            occurrences.put(c, occurrences.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (occurrences.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
