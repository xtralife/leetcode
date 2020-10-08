package com.github.xtralife.algorithms.heapsort;

import org.testng.annotations.Test;

import java.util.Arrays;

public class HeapsortTest {
    @Test
    public void testHeapsort() {
        int[] nums = {3, 5, 6, 1, 0, 4, 9, 8, 7};
        Heapsort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
