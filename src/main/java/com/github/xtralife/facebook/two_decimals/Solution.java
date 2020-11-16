package com.github.xtralife.facebook.two_decimals;

public class Solution {

    public String addBigNumbers(String one, String two) {
        String[] oneParts = one.split("\\.");
        String[] twoParts = two.split("\\.");
        String decimal = sumDecimal(oneParts[1], twoParts[1]);
        String integer = sum(oneParts[0], twoParts[0]);
        if (decimal.length() > Math.max(oneParts[1].length(), twoParts[1].length())) {
            integer = sum(integer, "1");
            decimal = decimal.substring(1); // My Bad!
        }
        return integer + "." + decimal;
    }

    private String sumDecimal(String one, String two) {
        if (one.length() < two.length()) {
            one = update(one, two.length() - one.length());
        } else {
            two = update(two, one.length() - two.length());
        }
        return sum(one, two);
    }

    private String update(String str, int length) {
        StringBuilder strBuilder = new StringBuilder(str);
        for (int i = 0; i < length; i++) {
            strBuilder.append('0');
        }
        return strBuilder.toString();
    }

    private String sum(String one, String two) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int oneP = one.length() - 1;
        int twoP = two.length() - 1;
        while (oneP >= 0 || twoP >= 0) {
            int currSum = carry;
            if (oneP >= 0) {
                currSum += one.charAt(oneP--) - '0';
            }
            if (twoP >= 0) {
                currSum += two.charAt(twoP--) - '0';
            }
            sb.append(currSum % 10);
            carry = currSum / 10;
        }
        if (carry == 1) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
