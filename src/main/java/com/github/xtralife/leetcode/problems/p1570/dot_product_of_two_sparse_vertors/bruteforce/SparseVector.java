package com.github.xtralife.leetcode.problems.p1570.dot_product_of_two_sparse_vertors.bruteforce;

public class SparseVector {
    int[] nums;

    SparseVector(int[] nums) {
        this.nums = nums;
    }

    // Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] * vec.nums[i];
        }
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
