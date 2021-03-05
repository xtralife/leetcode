package com.github.xtralife.leetcode.problems.p986.interval_list_intersections;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if (A.length == 0 || B.length == 0)  {
            return new int[][] {};
        }

        int ap = 0;
        int bp = 0;
        List<int[]> result = new ArrayList<>();
        while (ap < A.length && bp < B.length) {
            if (overlap(A[ap], B[bp])) {
                int[] overlapping = new int[2];
                overlapping[0] = Math.max(A[ap][0], B[bp][0]);
                overlapping[1] = Math.min(A[ap][1], B[bp][1]);
                result.add(overlapping);
                if (A[ap][1] == B[bp][1]) {
                    ap++;
                    bp++;
                } else if (A[ap][1] < B[bp][1]) {
                    ap++;
                } else {
                    bp++;
                }
            } else {
                if (A[ap][0] < B[bp][0]) {
                    ap++;
                } else {
                    bp++;
                }
            }
        }
        return result.toArray(new int[0][]);
    }

    private boolean overlap(int[] A, int[] B) {
        return A[1] >= B[0] && A[0] <= B[1];
    }
}
