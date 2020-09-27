package com.github.xtralife.leetcode.problems.p278.first_bad_version;

public class VersionControl {
    boolean isBadVersion(int version) {
        if (version > 5) {
            return true;
        }
        return false;
    }
}
