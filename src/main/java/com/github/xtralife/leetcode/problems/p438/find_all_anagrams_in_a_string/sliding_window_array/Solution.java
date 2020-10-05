package com.github.xtralife.leetcode.problems.p438.find_all_anagrams_in_a_string.sliding_window_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        List<Integer> result = new ArrayList<>();
        if (sLength < pLength) {
            return result;
        }

        int[] pArray = new int[26];
        fillArray(pArray, p);

        int[] sArray = new int[26];
        fillArray(sArray, s.substring(0, pLength));
        for (int i = 0; i < sLength - pLength; i++) {
            if (Arrays.equals(sArray, pArray)) {
                result.add(i);
            }
            sArray[s.charAt(i) - 'a']--;
            sArray[s.charAt(i + pLength) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) {
            result.add(sLength - pLength);
        }
        return result;
    }

    private void fillArray(int[] array, String input) {
        for (char ch : input.toCharArray()) {
            array[ch - 'a']++;
        }
    }
}
