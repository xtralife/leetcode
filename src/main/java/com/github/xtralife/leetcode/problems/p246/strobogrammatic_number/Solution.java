package com.github.xtralife.leetcode.problems.p246.strobogrammatic_number;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private final Map<Character, Character> map = new HashMap<>();
    {
        map.put('0', '0');
        map.put('1', '1');
        map.put('2', 'a');
        map.put('3', 'a');
        map.put('4', 'a');
        map.put('5', 'a');
        map.put('6', '9');
        map.put('7', 'a');
        map.put('8', '8');
        map.put('9', '6');
    }
    public boolean isStrobogrammatic(String num) { // "962"
        int head = 0; //1
        int tail = num.length() - 1; // 2
        while (head <= tail) {
            if (num.charAt(head++) != map.get(num.charAt(tail--))) { // 9
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.isStrobogrammatic("962");
        assert !result;
    }
}

