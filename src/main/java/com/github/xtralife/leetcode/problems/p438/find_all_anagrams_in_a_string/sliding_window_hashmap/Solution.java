package com.github.xtralife.leetcode.problems.p438.find_all_anagrams_in_a_string.sliding_window_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLength = s.length();
        int pLength = p.length();

        if (sLength < pLength) {
            return result;
        }

        Map<Character, Integer> pMap = stringToMap(p);
        Map<Character, Integer> sMap = stringToMap(s.substring(0, pLength));

        for (int i = 0; i < sLength - pLength; i++) {
            if (pMap.equals(sMap)) {
                result.add(i);
            }
            sMap.put(s.charAt(i), sMap.get(s.charAt(i)) - 1);
            sMap.remove(s.charAt(i), 0);
            sMap.put(s.charAt(i + pLength), sMap.getOrDefault(s.charAt(i + pLength), 0) + 1);
        }
        if (pMap.equals(sMap)) {
            result.add(sLength - pLength);
        }
        return result;
    }

    private Map<Character, Integer> stringToMap(String input) {
        Map<Character, Integer> result = new HashMap<>();
        for (char ch : input.toCharArray()) {
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }
        return result;
    }
}
