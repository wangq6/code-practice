package com.leetcode.java.algorithm;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MedianFinderTest {

    private MedianFinder medianfinder;

    @Before
    public void setUp() throws Exception {
        medianfinder = new MedianFinder();
    }

    @Test
    public void testFindMedian() {
        medianfinder.addNum(2);
        assertEquals(2, medianfinder.findMedian(), 0);
        medianfinder.addNum(-5);
        assertEquals(-1.5, medianfinder.findMedian(), 0);
        medianfinder.addNum(6);
        assertEquals(2, medianfinder.findMedian(), 0);
        medianfinder.addNum(-8);
        assertEquals(-1.5, medianfinder.findMedian(), 0);
        medianfinder.addNum(3);
        assertEquals(2, medianfinder.findMedian(), 0);
        medianfinder.addNum(-3);
        assertEquals(-0.5, medianfinder.findMedian(), 0);
        medianfinder.addNum(87);
        assertEquals(2, medianfinder.findMedian(), 0);
        medianfinder.addNum(234);
        assertEquals(2.5, medianfinder.findMedian(), 0);
        medianfinder.addNum(256);
        assertEquals(3, medianfinder.findMedian(), 0);
        medianfinder.addNum(235);
        assertEquals(4.5, medianfinder.findMedian(), 0);
        medianfinder.addNum(326);
        assertEquals(6, medianfinder.findMedian(), 0);
        medianfinder.addNum(765);
        assertEquals(46.5, medianfinder.findMedian(), 0);
        medianfinder.addNum(23);
        assertEquals(23, medianfinder.findMedian(), 0);
        medianfinder.addNum(-645);
        assertEquals(14.5, medianfinder.findMedian(), 0);
    }

}
