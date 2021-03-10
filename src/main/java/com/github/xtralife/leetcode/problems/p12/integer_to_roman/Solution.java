package com.github.xtralife.leetcode.problems.p12.integer_to_roman;

public class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        int pointer = 0;
        while (num > 0) {
            if (nums[pointer] > num) {
                pointer++;
                continue;
            }
            result.append(roms[pointer]);
            num -= nums[pointer];
        }
        return result.toString();
    }
}
