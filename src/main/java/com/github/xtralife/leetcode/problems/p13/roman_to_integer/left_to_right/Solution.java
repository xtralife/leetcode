package com.github.xtralife.leetcode.problems.p13.roman_to_integer.left_to_right;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Character, Integer> romans = new HashMap<>();

    {
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i > 1 && romans.get(s.charAt(i)) < romans.get(s.charAt(i + 1))) {
                result -= romans.get(s.charAt(i));
                result += romans.get(s.charAt(i++ + 1));
            } else {
                result += romans.get(s.charAt(i));
            }
        }
        return result;
    }
}
