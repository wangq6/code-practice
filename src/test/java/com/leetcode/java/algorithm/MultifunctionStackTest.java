package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MultifunctionStackTest {

    private MultifunctionStack multifunctionStack;

    @Before
    public void setUp() throws Exception {
        multifunctionStack = new MultifunctionStack();
        multifunctionStack.push(54);
        multifunctionStack.push(38);
        multifunctionStack.push(48);
        multifunctionStack.push(59);
        multifunctionStack.push(22);
        multifunctionStack.push(35);
        multifunctionStack.push(45);
        multifunctionStack.push(59);
        multifunctionStack.push(59);
        multifunctionStack.push(53);
        multifunctionStack.push(67);
        multifunctionStack.push(81);
        multifunctionStack.push(78);
        multifunctionStack.push(73);
        multifunctionStack.push(19);
        multifunctionStack.push(52);
        multifunctionStack.push(24);
        multifunctionStack.push(59);
        multifunctionStack.push(69);
        multifunctionStack.push(87);
        multifunctionStack.push(30);
        multifunctionStack.push(45);
        multifunctionStack.push(84);
    }

    @Test
    public void testGetMin() {
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(84, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(45, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(30, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(87, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(69, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(59, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(24, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(52, multifunctionStack.pop());
        assertEquals(19, multifunctionStack.getMin());
        assertEquals(19, multifunctionStack.pop());
        assertEquals(22, multifunctionStack.getMin());
        assertEquals(73, multifunctionStack.pop());
        assertEquals(22, multifunctionStack.getMin());
    }

    @Test
    public void testGetMax() {
        assertEquals(87, multifunctionStack.getMax());
        assertEquals(84, multifunctionStack.pop());
        assertEquals(87, multifunctionStack.getMax());
        assertEquals(45, multifunctionStack.pop());
        assertEquals(87, multifunctionStack.getMax());
        assertEquals(30, multifunctionStack.pop());
        assertEquals(87, multifunctionStack.getMax());
        assertEquals(87, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
        assertEquals(69, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
        assertEquals(59, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
        assertEquals(24, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
        assertEquals(52, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
        assertEquals(19, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
        assertEquals(73, multifunctionStack.pop());
        assertEquals(81, multifunctionStack.getMax());
    }

    @Test
    public void testGetAveage() {
        assertEquals(53, multifunctionStack.getAveage());
        assertEquals(84, multifunctionStack.pop());
        assertEquals(52, multifunctionStack.getAveage());
        assertEquals(45, multifunctionStack.pop());
        assertEquals(52, multifunctionStack.getAveage());
    }

    @Test
    public void testGetMedian() {
        multifunctionStack = new MultifunctionStack();
        multifunctionStack.push(54);
        multifunctionStack.push(38);
        multifunctionStack.push(48);
        multifunctionStack.push(59);
        multifunctionStack.push(22);
        multifunctionStack.push(35);
        multifunctionStack.push(45);
        assertEquals(45, multifunctionStack.getMedian(), 0);
        assertEquals(45, multifunctionStack.pop());
        assertEquals(43, multifunctionStack.getMedian(), 0);
        assertEquals(35, multifunctionStack.pop());
        assertEquals(48, multifunctionStack.getMedian(), 0);
        assertEquals(22, multifunctionStack.pop());
        assertEquals(51, multifunctionStack.getMedian(), 0);
        assertEquals(59, multifunctionStack.pop());
        assertEquals(48, multifunctionStack.getMedian(), 0);
    }

    @Test
    public void testGetMostFreq() throws Exception {
        assertEquals(59, multifunctionStack.getMostFreq());
        assertEquals(84, multifunctionStack.pop());
        assertEquals(59, multifunctionStack.getMostFreq());
        assertEquals(45, multifunctionStack.pop());
        assertEquals(59, multifunctionStack.getMostFreq());
        assertEquals(30, multifunctionStack.pop());
        assertEquals(59, multifunctionStack.getMostFreq());
        assertEquals(87, multifunctionStack.pop());
        assertEquals(59, multifunctionStack.getMostFreq());
        assertEquals(69, multifunctionStack.pop());
        assertEquals(59, multifunctionStack.getMostFreq());
        assertEquals(59, multifunctionStack.pop());
        assertEquals(59, multifunctionStack.getMostFreq());
        multifunctionStack.push(45);
        assertEquals(59, multifunctionStack.getMostFreq());
        multifunctionStack.push(45);
        multifunctionStack.push(45);
        assertEquals(45, multifunctionStack.getMostFreq());
    }

}
