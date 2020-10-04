package com.github.xtralife.leetcode.problems.p953.verifying_an_alien_dictionary;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> alphabet = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alphabet.put(order.charAt(i), i);
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (alienComparator(alphabet).compare(words[i], words[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private Comparator<String> alienComparator(Map<Character, Integer> alphabet) {
        return (s1, s2) -> {
            if (s1.equals(s2)) {
                return 0;
            }
            int length = Math.min(s1.length(), s2.length());
            for (int i = 0; i < length; i++) {
                if (alphabet.get(s1.charAt(i)) < alphabet.get(s2.charAt(i))) {
                    return -1;
                } else if (alphabet.get(s1.charAt(i)) > alphabet.get(s2.charAt(i))) {
                    return 1;
                }
            }
            if (s1.length() > s2.length()) {
                return 1;
            } else {
                return -1;
            }
        };
    }
}
