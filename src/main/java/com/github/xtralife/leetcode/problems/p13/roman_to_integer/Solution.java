package com.github.xtralife.leetcode.problems.p13.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<String, Integer> romans = new HashMap<>();

    {
        romans.put("I", 1);
        romans.put("IV", 4);
        romans.put("V", 5);
        romans.put("IX", 9);
        romans.put("X", 10);
        romans.put("XL", 40);
        romans.put("L", 50);
        romans.put("XC", 90);
        romans.put("C", 100);
        romans.put("CD", 400);
        romans.put("D", 500);
        romans.put("CM", 900);
        romans.put("M", 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        int pointer = s.length() - 1;
        while (!s.isEmpty()) {
            while (pointer >= 0 && romans.containsKey(s.substring(pointer))) {
                pointer--;
            }
            String tail = s.substring(pointer + 1);
            result += romans.get(tail);
            s = s.substring(0, pointer + 1);
        }
        return result;
    }
}