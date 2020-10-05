package com.github.xtralife.leetcode.problems.p158.read_n_characters_given_read4_ii_call_multiple_times;

/**
 * The read4 API is defined in the parent class Reader4.
 * int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    private final char[] cache = new char[4];
    private int cacheSize = 0;
    private boolean eof = false;

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int doneRead = 0;
        if (cacheSize > 0) {
            if (cacheSize <= n) {
                System.arraycopy(cache, 0, buf, doneRead, cacheSize);
                doneRead += cacheSize;
                cacheSize = 0;
            } else {
                System.arraycopy(cache, 0, buf, doneRead, n);
                doneRead += n;
                cacheSize -= n;
                System.arraycopy(cache, n, cache, 0, cacheSize);
                return doneRead;
            }
        }
        char[] buf4 = new char[4];
        while (!eof && n > doneRead) {
            int read4 = read4(buf4);
            if (read4 < 4) {
                eof = true;
            }
            if (n - doneRead >= read4) {
                System.arraycopy(buf4, 0, buf, doneRead, read4);
                doneRead += read4;
            } else {
                System.arraycopy(buf4, 0, buf, doneRead, n - doneRead);
                cacheSize = read4 - n + doneRead;
                System.arraycopy(buf4, n - doneRead, cache, 0, cacheSize);
                doneRead = n;
            }
        }
        return doneRead;
    }
}