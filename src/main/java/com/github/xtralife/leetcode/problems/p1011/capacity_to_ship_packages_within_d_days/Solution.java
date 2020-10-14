package com.github.xtralife.leetcode.problems.p1011.capacity_to_ship_packages_within_d_days;

public class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int min = 0;
        int max = 0;
        for (int weight : weights) {
            min = Math.max(min, weight);
            max += weight;
        }
        if (calcDays(weights, min) <= D) {
            return min;
        }
        while (max - min > 1) {
            int mid = min + (max - min) / 2;
            int days = calcDays(weights, mid);
            if (days > D) {
                min = mid;
            } else {
                max = mid;
            }
        }
        return max;
    }

    private int calcDays(int[] w, int cap) {
        int days = 1;
        int currCap = 0;
        for (int weight : w) {
            if (currCap + weight <= cap) {
                currCap += weight;
            } else {
                days++;
                currCap = weight;
            }
        }
        return days;
    }
}
