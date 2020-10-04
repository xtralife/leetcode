package com.github.xtralife.leetcode.problems.p273.integer_to_english_words.divide_and_conquer;

public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int billion = num / 1000000000;
        int million = (num % 1000000000) / 1000000;
        int thousand = (num % 1000000) / 1000;
        if (billion > 0) {
            result += convert(billion) + " Billion";
        }
        if (million > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += convert(million) + " Million";
        }
        if (thousand > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += convert(thousand) + " Thousand";
        }
        int rest = num % 1000;
        if (rest > 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += convert(rest);
        }
        return result;
    }

    private String convert(int part) {
        int hundreds = part / 100;
        int twos = part % 100;
        String result = "";
        if (hundreds > 0) {
            result += ones(hundreds) + " Hundred";
        }
        if (twos > 0) {
            if (twos < 20) {
                if (!result.isEmpty()) {
                    result += " ";
                }
                return result + ones(twos);
            }
            int tens = twos / 10;
            int rest = twos % 10;
            if (!result.isEmpty()) {
                result += " ";
            }
            result += tens(tens);
            if (rest > 0) {
                if (!result.isEmpty()) {
                    result += " ";
                }
                result += ones(rest);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.numberToWords(101);
        System.out.println(result);
    }

    private String ones(int num) {
        switch (num) {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }

    private String tens(int num) {
        switch (num) {
            case 2:
                return "Twenty";
            case 3:
                return "Thirty";
            case 4:
                return "Forty";
            case 5:
                return "Fifty";
            case 6:
                return "Sixty";
            case 7:
                return "Seventy";
            case 8:
                return "Eighty";
            case 9:
                return "Ninety";
        }
        return "";
    }
}
