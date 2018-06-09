package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class PowerOfFourTest {

    @Test
    public void testIsPowerOfFour() {
        assertFalse(PowerOfFour.isPowerOfFour(-4));
        assertFalse(PowerOfFour.isPowerOfFour(-1));
        assertFalse(PowerOfFour.isPowerOfFour(0));
        assertTrue(PowerOfFour.isPowerOfFour(1));
        assertFalse(PowerOfFour.isPowerOfFour(2));
        assertFalse(PowerOfFour.isPowerOfFour(3));
        assertTrue(PowerOfFour.isPowerOfFour(4));
        assertFalse(PowerOfFour.isPowerOfFour(10));
        assertTrue(PowerOfFour.isPowerOfFour(16));
        assertFalse(PowerOfFour.isPowerOfFour(32));
        assertTrue(PowerOfFour.isPowerOfFour(64));
        assertFalse(PowerOfFour.isPowerOfFour(100));
        assertFalse(PowerOfFour.isPowerOfFour(128));
        assertTrue(PowerOfFour.isPowerOfFour(1024));
        assertFalse(PowerOfFour.isPowerOfFour(2048));
        assertTrue(PowerOfFour.isPowerOfFour(4096));
        assertTrue(PowerOfFour.isPowerOfFour(16777216));
    }
    
    @Test
    public void testIsPowerOfFourLong() {
        assertFalse(PowerOfFour.isPowerOfFour(-4L));
        assertFalse(PowerOfFour.isPowerOfFour(-1L));
        assertFalse(PowerOfFour.isPowerOfFour(0L));
        assertTrue(PowerOfFour.isPowerOfFour(1L));
        assertFalse(PowerOfFour.isPowerOfFour(2L));
        assertFalse(PowerOfFour.isPowerOfFour(3L));
        assertTrue(PowerOfFour.isPowerOfFour(4L));
        assertFalse(PowerOfFour.isPowerOfFour(10L));
        assertTrue(PowerOfFour.isPowerOfFour(16L));
        assertFalse(PowerOfFour.isPowerOfFour(32L));
        assertTrue(PowerOfFour.isPowerOfFour(64L));
        assertFalse(PowerOfFour.isPowerOfFour(100L));
        assertFalse(PowerOfFour.isPowerOfFour(128L));
        assertTrue(PowerOfFour.isPowerOfFour(1024L));
        assertFalse(PowerOfFour.isPowerOfFour(2048L));
        assertTrue(PowerOfFour.isPowerOfFour(4096L));
        assertTrue(PowerOfFour.isPowerOfFour(68719476736L));
    }

}
