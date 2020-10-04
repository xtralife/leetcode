package com.github.xtralife.leetcode.problems.p273.integer_to_english_words;

import java.util.Stack;

public class Solution {
    private final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thirds = {" Hundred"};
    private final String[] triades = {"", " Thousand", " Million", " Billion"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        Stack<String> result = new Stack<>();
        int triade = 0;
        while (num > 0) {
            int part = num % 1000;
            num /= 1000;
            String converted = convertTriade(part);
            if (!converted.isEmpty()) {
                if (!result.isEmpty()) {
                    result.push(" ");
                }
                result.push(triades[triade]);
                result.push(convertTriade(part));
            }
            triade++;
        }
        StringBuilder builder = new StringBuilder();
        while (!result.isEmpty()) {
            builder.append(result.pop());
        }
        return builder.toString();
    }

    private String convertTriade(int part) {
        StringBuilder builder = new StringBuilder();
        int hundreds = part / 100;
        if (hundreds > 0) {
            builder.append(ones[hundreds]).append(thirds[0]);
        }
        part %= 100;
        if (part == 0) {
            return builder.toString();
        }
        if (hundreds > 0) {
            builder.append(" ");
        }
        if (part < 20) {
            builder.append(ones[part]);
            return builder.toString();
        }
        builder.append(tens[part / 10]);
        if (part % 10 > 0) {
            builder.append(" ").append(ones[part % 10]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.numberToWords(20);
        System.out.println(result);
    }
}
