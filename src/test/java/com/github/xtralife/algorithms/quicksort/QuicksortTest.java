package com.github.xtralife.algorithms.quicksort;

import com.github.xtralife.algorithms.quicksort.hoare.Quicksort;
import org.testng.annotations.Test;

public class QuicksortTest {
    @Test
    public void testQuicksort() {
        int[] result = Quicksort.quicksort(new int[]{3, 7, 5, 4, 0, 6, 2, 8, 1});
        for (int i = 0; i < 6; i++) {
            assert result[i] == i;
        }
    }
}
