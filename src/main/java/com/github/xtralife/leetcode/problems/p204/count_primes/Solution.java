package com.github.xtralife.leetcode.problems.p204.count_primes;

public class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
            return 0;
        }
        boolean[] nonPrimes = new boolean[n];
        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (!nonPrimes[i]) {
                count++;
                int j = i;
                while (j < n) {
                    nonPrimes[j] = true;
                    j += i;
                }
            }
        }
        return count;
    }
}
