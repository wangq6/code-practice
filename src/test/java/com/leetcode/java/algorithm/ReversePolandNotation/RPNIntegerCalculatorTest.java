package com.leetcode.java.algorithm.ReversePolandNotation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RPNIntegerCalculatorTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testOneOperation() {
        assertEquals(4, RPNIntegerCalculator.evaluate("2 2 +"));
        assertEquals(8, RPNIntegerCalculator.evaluate("10 2 -"));
        assertEquals(12, RPNIntegerCalculator.evaluate("6 ++"));
        assertEquals(12, RPNIntegerCalculator.evaluate("2 6 *"));
        assertEquals(1, RPNIntegerCalculator.evaluate("2 2 /"));
        assertEquals(81, RPNIntegerCalculator.evaluate("9 **"));
        assertEquals(24, RPNIntegerCalculator.evaluate("8 7 9 +++"));
    }

    @Test
    public void testMultipleOperation() {
        assertEquals(8, RPNIntegerCalculator.evaluate("2 10 2 3 6 + 7 4 4 - 3543 / 645 ** / + - + - +"));
    }
}
