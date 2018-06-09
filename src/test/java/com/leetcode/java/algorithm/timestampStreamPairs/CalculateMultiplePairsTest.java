package com.leetcode.java.algorithm.timestampStreamPairs;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.java.algorithm.timestampStreamPairs.CalculateMultiplePairs;
import com.leetcode.java.algorithm.timestampStreamPairs.TimestampStream;

public class CalculateMultiplePairsTest {

    private CalculateMultiplePairs calculateMultiplePairs;

    @Before
    public void setUp() throws Exception {
        List<Double> l1 = Arrays.asList(0.2, 1.4, 3.0, 4.6, 5.3);
        List<Double> l2 = Arrays.asList(2.0, 2.1, 4.5, 6.0);
        List<Double> l3 = Arrays.asList(3.2, 4.1, 4.7, 6.2, 6.5);
        TimestampStream s1 = new TimestampStream(l1);
        TimestampStream s2 = new TimestampStream(l2);
        TimestampStream s3 = new TimestampStream(l3);
        calculateMultiplePairs = new CalculateMultiplePairs(new TimestampStream[] { s1, s2, s3 });
    }

    @Test
    public void test() throws InterruptedException {
        List<Double[]> result = calculateMultiplePairs.getDistanceLessThanOne();
        System.out.println(Arrays.deepToString(result.toArray()));
    }

}
