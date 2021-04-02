package com.github.xtralife.leetcode.problems.p17.letter_combinations_of_a_phone_number.recursion;

import java.util.*;

public class Solution {
    private final Map<Character, String> map = new HashMap<>();

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
        return create(Collections.singletonList(""), 0, digits);
    }

    private List<String> create(List<String> current, int pointer, String digits) {
        if (pointer == digits.length()) {
            return current;
        }
        List<String> result = new ArrayList<>();
        for (String cur : current) {
            for (char ch : map.get(digits.charAt(pointer)).toCharArray()) {
                result.add(cur + ch);
            }
        }
        return create(result, pointer + 1, digits);
    }
}
