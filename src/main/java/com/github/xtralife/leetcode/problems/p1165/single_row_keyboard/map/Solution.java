package com.github.xtralife.leetcode.problems.p1165.single_row_keyboard.map;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> positions = new HashMap<>();
        for (int i = 0; i < keyboard.length(); i++) {
            positions.put(keyboard.charAt(i), i);
        }
        int result = 0;
        int prev = 0;
        for (char ch : word.toCharArray()) {
            int curr = positions.get(ch);
            result += Math.abs(curr - prev);
            prev = curr;
        }
        return result;
    }
}
