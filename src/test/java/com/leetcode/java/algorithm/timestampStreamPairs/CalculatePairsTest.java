package com.leetcode.java.algorithm.timestampStreamPairs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.java.algorithm.timestampStreamPairs.CalculatePairs;
import com.leetcode.java.algorithm.timestampStreamPairs.TimestampStream;

public class CalculatePairsTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() throws InterruptedException {
        int counter = 100;
        while (counter > 0) {
            List<Double> l1 = Arrays.asList(0.2, 1.4, 3.0, 4.6, 5.3, 6.7);
            List<Double> l2 = Arrays.asList(2.0, 2.1, 4.5, 6.0);
            TimestampStream s1 = new TimestampStream(l1);
            TimestampStream s2 = new TimestampStream(l2);
            List<Double[]> result = CalculatePairs.getDistanceLessThanOne(s1, s2);
            System.out.println(Arrays.deepToString(result.toArray()));
            assertEquals(7, result.size());
            counter--;
        }
    }

}
