package com.github.xtralife.leetcode.problems.p1165.single_row_keyboard.array;

public class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] positions = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            positions[keyboard.charAt(i) - 'a'] = i;
        }
        int prev = 0;
        int result = 0;
        for (char ch : word.toCharArray()) {
            int curr = positions[ch - 'a'];
            result += Math.abs(curr - prev);
            prev = curr;
        }
        return result;
    }
}
