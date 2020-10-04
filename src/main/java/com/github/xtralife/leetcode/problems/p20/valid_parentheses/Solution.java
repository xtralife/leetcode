package com.github.xtralife.leetcode.problems.p20.valid_parentheses;

import java.util.*;

public class Solution {
    private final List<Character> open = Arrays.asList('{', '[', '(');
    private final Map<Character, Character> close = new HashMap<>();
    {
        close.put('}', '{');
        close.put(')', '(');
        close.put(']', '[');
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || close.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpen(Character character) {
        return open.contains(character);
    }
}
