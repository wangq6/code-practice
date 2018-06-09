/**
 * 
 */
package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Gynubi
 *
 */
public class WeightedRandomNumberTest {

    private WeightedRandomNumber<String> weightedRandomNumber;
    private List<String> testList;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        weightedRandomNumber = new WeightedRandomNumber();
        testList = new ArrayList<>();
    }

    /**
     * Test method for
     * {@link com.leetcode.java.algorithm.WeightedRandomNumber#put(java.lang.Object, int)}.
     */
    @Test
    public void testFetch1000times() {
        int count = 1000;
        double[] result = new double[3];

        weightedRandomNumber.put("a", 3);
        weightedRandomNumber.put("b", 3);
        weightedRandomNumber.put("c", 4);

        while (count > 0) {
            testList.add(weightedRandomNumber.fetch());
            count--;
        }

        for (String s : testList) {
            if (s.equals("a")) {
                result[0] += 1;
            } else if (s.equals("b")) {
                result[1] += 1;
            } else if (s.equals("c")) {
                result[2] += 1;
            } else {
                fail("Invalid key");
            }
        }

        count = 1000;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                assertTrue(result[0] / count >= 0.25);
                assertTrue(result[0] / count <= 0.35);
            } else if (i == 1) {
                assertTrue(result[1] / count >= 0.25);
                assertTrue(result[1] / count <= 0.35);
            } else {
                assertTrue(result[2] / count >= 0.35);
                assertTrue(result[2] / count <= 0.45);
            }
        }
    }

    /**
     * Test method for
     * {@link com.leetcode.java.algorithm.WeightedRandomNumber#fetch()}.
     */
    @Test
    public void testFetch10000times() {
        int count = 10000;
        double[] result = new double[3];

        weightedRandomNumber.put("a", 3);
        weightedRandomNumber.put("b", 3);
        weightedRandomNumber.put("c", 4);

        while (count > 0) {
            testList.add(weightedRandomNumber.fetch());
            count--;
        }

        for (String s : testList) {
            if (s.equals("a")) {
                result[0] += 1;
            } else if (s.equals("b")) {
                result[1] += 1;
            } else if (s.equals("c")) {
                result[2] += 1;
            } else {
                fail("Invalid key");
            }
        }

        count = 10000;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                assertTrue(result[0] / count >= 0.28);
                assertTrue(result[0] / count <= 0.32);
            } else if (i == 1) {
                assertTrue(result[1] / count >= 0.28);
                assertTrue(result[1] / count <= 0.32);
            } else {
                assertTrue(result[2] / count >= 0.38);
                assertTrue(result[2] / count <= 0.42);
            }
        }
    }

    @Test
    public void testFetch100000times() {
        int count = 100000;
        double[] result = new double[3];

        weightedRandomNumber.put("a", 3);
        weightedRandomNumber.put("b", 45353);
        weightedRandomNumber.put("b", 3);
        weightedRandomNumber.put("c", 4);

        while (count > 0) {
            testList.add(weightedRandomNumber.fetch());
            count--;
        }

        for (String s : testList) {
            if (s.equals("a")) {
                result[0] += 1;
            } else if (s.equals("b")) {
                result[1] += 1;
            } else if (s.equals("c")) {
                result[2] += 1;
            } else {
                fail("Invalid key");
            }
        }

        count = 100000;
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                assertTrue(result[0] / count >= 0.29);
                assertTrue(result[0] / count <= 0.31);
            } else if (i == 1) {
                assertTrue(result[1] / count >= 0.29);
                assertTrue(result[1] / count <= 0.31);
            } else {
                assertTrue(result[2] / count >= 0.39);
                assertTrue(result[2] / count <= 0.41);
            }
        }
    }
}
