package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MedianOfTwoSortedArraysTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testZeroSize() {
        int[] A = new int[] {};
        int[] B = new int[] {};
        double result = MedianOfTwoSortedArrays.findMedian(A, B);
        assertEquals(0, result, 0);
    }

    @Test
    public void testOddSize() {
        int[] A = new int[] { 35, 43, 56, 62, 88, 90, 101, 168, 190, 222, 229, 231, 280, 301, 335, 471, 472, 477, 482,
                488, 533, 550, 561, 578, 616, 639, 641, 653, 671, 676, 702, 706, 711, 730, 735, 746, 748, 750, 765, 768,
                780, 786, 788, 807, 915, 925, 945, 955, 968 };
        int[] B = new int[] { 10, 44, 46, 49, 69, 82, 198, 199, 253, 256, 262, 283, 285, 293, 305, 315, 317, 347, 380,
                451, 466, 468, 476, 487, 490, 495, 523, 549, 601, 610, 625, 639, 654, 678, 684, 748, 759, 762, 785, 793,
                806, 827, 841, 864, 926, 927, 955, 968 };
        double result = MedianOfTwoSortedArrays.findMedian(A, B);
        assertEquals(549, result, 0);
    }

    @Test
    public void testEvenSize() {
        int[] A = new int[] { 35, 43, 56, 62, 88, 90, 101, 168, 190, 222, 229, 231, 280, 301, 335, 471, 472, 477, 482,
                488, 533, 550, 561, 578, 616, 639, 641, 653, 671, 676, 702, 706, 711, 730, 735, 746, 748, 750, 765, 768,
                780, 786, 788, 807, 915, 925, 945, 955, 968, 974 };
        int[] B = new int[] { 10, 44, 46, 49, 69, 82, 198, 199, 253, 256, 262, 283, 285, 293, 305, 315, 317, 347, 380,
                451, 466, 468, 476, 487, 490, 495, 523, 549, 601, 610, 625, 639, 654, 678, 684, 748, 759, 762, 785, 793,
                806, 827, 841, 864, 926, 927, 955, 968 };
        double result = MedianOfTwoSortedArrays.findMedian(A, B);
        assertEquals(549.5, result, 0);
    }

}
