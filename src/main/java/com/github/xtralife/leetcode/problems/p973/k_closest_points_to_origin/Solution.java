package com.github.xtralife.leetcode.problems.p973.k_closest_points_to_origin;

import java.util.*;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        SortedMap<Double, List<int[]>> map = new TreeMap<>();
        for (int[] point : points) {
            Double dist = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            map.putIfAbsent(dist, new ArrayList<>());
            map.get(dist).add(point);
        }
        int[][] result = new int[k][2];
        int count = 0;
        outer:
        for (Map.Entry<Double, List<int[]>> entry : map.entrySet()) {
            for (int[] point : entry.getValue()) {
                result[count++] = point;
                if (count == k) {
                    break outer;
                }
            }
        }
        return result;
    }
}
