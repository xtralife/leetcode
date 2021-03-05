package com.github.xtralife.leetcode.problems.p986.interval_list_intersections.min_endpoint;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int ap = 0;
        int bp = 0;
        List<int[]> result = new ArrayList<>();
        while (ap < A.length && bp < B.length) {
            int lo = Math.max(A[ap][0], B[bp][0]);
            int hi = Math.min(A[ap][1], B[bp][1]);
            if (lo <= hi) {
                result.add(new int[]{lo, hi});
            }
            if (A[ap][1] < B[bp][1]) {
                ap++;
            } else {
                bp++;
            }
        }
        return result.toArray(new int[0][]);
    }
}
