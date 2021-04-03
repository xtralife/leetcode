package com.github.xtralife.leetcode.problems.p780.reaching_points;

public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (tx == ty) {
            return sx == sy && sx == tx;
        }
        return canReach(sx, sy, tx, ty);
    }

    private boolean canReach(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) {
            return false;
        }
        int tLow = Math.min(tx, ty);
        int tHigh = Math.max(tx, ty);
        int sLow = Math.min(sx, sy);
        int sHigh = Math.max(sx, sy);
        tHigh = tHigh % tLow;

        if (tLow == sLow && tHigh == sHigh % sLow) {
            return true;
        }
        tx = tx == tLow ? tLow : tHigh;
        ty = ty == tLow ? tLow : tHigh;
        return canReach(sx, sy, tx, ty);
    }
}
