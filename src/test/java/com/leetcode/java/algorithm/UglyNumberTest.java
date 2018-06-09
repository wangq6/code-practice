package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UglyNumberTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        List<Integer> result = UglyNumber.getUglyNumberSmallerThanN(100, 2, 3);
        List<Integer> expected = Arrays.asList(2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 27, 32, 36, 48, 54, 64, 72, 81, 96);
        assertTrue(Arrays.equals(expected.toArray(), result.toArray()));
    }

}
