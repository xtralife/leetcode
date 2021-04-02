package com.github.xtralife.leetcode.problems.p17.letter_combinations_of_a_phone_number.backtracking;

import java.util.*;

public class Solution {
    private final Map<Character, String> map = new HashMap<>();
    private List<String> combinations;

    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        combinations = new ArrayList<>();
        backtrack(0, digits, new StringBuilder());
        return combinations;
    }

    private void backtrack(int pointer, String digits, StringBuilder sb) {
        if (pointer == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        for (char ch : map.get(digits.charAt(pointer)).toCharArray()) {
            sb.append(ch);
            backtrack(pointer + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
