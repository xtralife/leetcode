package com.github.xtralife.leetcode.problems.p438.find_all_anagrams_in_a_string.naive_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LTE on LeetCode
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = stringToMap(p);

        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (isAnagram(sub, pMap)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(String input, Map<Character, Integer> etalon) {
        Map<Character, Integer> inputMap = stringToMap(input);
        for (char ch : inputMap.keySet()) {
            if (inputMap.get(ch).equals(etalon.get(ch))) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> stringToMap(String input) {
        Map<Character, Integer> result = new HashMap<>();
        for (char ch : input.toCharArray()) {
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }
        return result;
    }
}
