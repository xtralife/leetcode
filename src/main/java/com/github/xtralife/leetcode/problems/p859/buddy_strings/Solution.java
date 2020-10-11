package com.github.xtralife.leetcode.problems.p859.buddy_strings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean buddyStrings(String a, String b) {
        Map<Character, Integer> chars = new HashMap<>();
        if (a.length() != b.length() || a.length() < 2) {
            return false;
        }
        int diffIndex = -1;
        int diffCount = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (diffCount == 0) {
                    diffCount++;
                    diffIndex = i;
                } else if (diffCount == 1) {
                    if (a.charAt(diffIndex) == b.charAt(i) && a.charAt(i) == b.charAt(diffIndex)) {
                        diffCount++;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (diffCount == 0) {
                chars.put(a.charAt(i), chars.getOrDefault(a.charAt(i), 0) + 1);
            }
        }
        if (diffCount == 1) {
            return false;
        }
        if (diffCount == 0) {
            return chars.values().stream().anyMatch(i -> i > 1);
        }
        return true;
    }
}
