package com.github.xtralife.leetcode.problems.p1570.dot_product_of_two_sparse_vertors.compressed;

import java.util.*;

public class SparseVector {
    private final Map<Integer, Integer> vector = new HashMap<>();

    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                vector.put(i, nums[i]);
            }
        }
    }

    public Map<Integer, Integer> getVector() {
        return vector;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        Set<Integer> indices = vector.keySet();
        indices.retainAll(vec.getVector().keySet());
        for (int index : indices) {
            result += vector.get(index) * vec.getVector().get(index);
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
