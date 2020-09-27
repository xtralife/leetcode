package com.github.xtralife.leetcode.problems.p278.first_bad_version;

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int maxGood = -1;
        int minBad = n;
        while (minBad - maxGood > 1) {
            int next = maxGood + (minBad - maxGood) / 2;
            if (isBadVersion(next)) {
                minBad = next;
            } else {
                maxGood = next;
            }
        }
        return minBad;
    }
}
