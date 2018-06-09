package com.leetcode.java.algorithm;

public class PowerOfFour {
    public static boolean isPowerOfFour(int num) {
        return num > 0 && ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }
    
    public static boolean isPowerOfFour(long num) {
        return num > 0 && ((num & (num - 1)) == 0) && ((num & 0x5555555555555555L) != 0);
    }
}
