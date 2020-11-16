package com.github.xtralife.algorithms.mergesort;

import com.github.xtralife.algorithms.heapsort.Heapsort;
import org.testng.annotations.Test;

import java.util.Arrays;

public class MergesortTest {
    @Test
    public void testMergesort() {
        int[] result = Mergesort.sort(new int[]{3, 7, 5, 4, 0, 6, 2, 8, 1});
        for (int i = 0; i < 9; i++) {
            assert result[i] == i;
        }
    }

    @Test
    public void test2MergeSort() {
        int[] nums = {3, 5, 6, 1, 0, 4, 9, 8, 7};
        Heapsort.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
