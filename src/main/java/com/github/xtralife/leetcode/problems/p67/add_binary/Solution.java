package com.github.xtralife.leetcode.problems.p67.add_binary;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sum = new StringBuilder();
        int aPointer = a.length() - 1;
        int bPointer = b.length() - 1;
        int carry = 0;
        while (aPointer >= 0 && bPointer >= 0) {
            int localSum = a.charAt(aPointer--) - '0' + b.charAt(bPointer--) - '0' + carry;
            sum.append(localSum % 2);
            carry = localSum / 2;
        }
        while (aPointer >= 0) {
            int localSum = a.charAt(aPointer--) - '0' + carry;
            sum.append(localSum % 2);
            carry = localSum / 2;
        }
        while (bPointer >= 0) {
            int localSum = b.charAt(bPointer--) - '0' + carry;
            sum.append(localSum % 2);
            carry = localSum / 2;
        }
        if (carry > 0) {
            sum.append('1');
        }
        return sum.reverse().toString();
    }
}
