package com.github.xtralife.leetcode.problems.p339.nested_list_weight_sum;

import java.util.List;

public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        return calcNestedList(nestedList, depth);
    }

    private int calcNestedList(List<NestedInteger> list, int depth) {
        return list.stream().mapToInt(nested -> calcNestedInteger(nested, depth)).sum();
    }

    private int calcNestedInteger(NestedInteger nested, int depth) {
        if (nested.isInteger()) {
            return nested.getInteger() * depth;
        }
        return calcNestedList(nested.getList(), depth + 1);
    }
}
