package com.leetcode.java.algorithm.Mod5Iterator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomIteratorDividableByFiveTest {

    private RandomIteratorDividableByFive iterator;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testEmpty() {
        int[] nums = new int[] {};
        iterator = new RandomIteratorDividableByFive(nums);
        assertTrue(iterator.next().equals(-1));
    }

    @Test
    public void testEmptyItem() {
        int[] nums = new int[] {};
        iterator = new RandomIteratorDividableByFive(nums);

        assertFalse(iterator.hasNext());
        assertTrue(iterator.next().equals(-1));
    }

    @Test
    public void test100Item() {
        int[] nums = new int[] { 76, 2, 44, 27, 62, 8, 80, 21, 48, 43, 65, 81, 97, 55, 94, 58, 50, 22, 47, 3, 23, 66,
                88, 59, 92, 37, 64, 17, 11, 9, 74, 100, 22, 80, 72, 20, 17, 47, 38, 98, 97, 81, 84, 44, 5, 77, 86, 92,
                32, 45, 32, 74, 7, 24, 32, 16, 79, 28, 89, 3, 11, 21, 18, 43, 43, 61, 71, 18, 82, 14, 35, 100, 50, 54,
                3, 60, 52, 76, 54, 75, 4, 9, 77, 73, 58, 18, 53, 96, 63, 28, 100, 81, 66, 94, 66, 27, 3, 37, 53, 16 };
        iterator = new RandomIteratorDividableByFive(nums);
        int counter = 0;

        for (int i : nums) {
            if (i % 5 == 0) {
                counter++;
            }
        }
        assertEquals(15, counter);
        while (counter > 0) {
            iterator.hasNext();
            iterator.hasNext();
            iterator.hasNext();
            if (iterator.next() % 5 == 0) {
                counter--;
            }
        }
        assertEquals(0, counter);
        assertFalse(iterator.hasNext());
        assertTrue(iterator.next().equals(-1));
    }

    @Test
    public void test100Remove() {
        int[] nums = new int[] { 76, 2, 44, 27, 62, 8, 80, 21, 48, 43, 65, 81, 97, 55, 94, 58, 50, 22, 47, 3, 23, 66,
                88, 59, 92, 37, 64, 17, 11, 9, 74, 100, 22, 80, 72, 20, 17, 47, 38, 98, 97, 81, 84, 44, 5, 77, 86, 92,
                32, 45, 32, 74, 7, 24, 32, 16, 79, 28, 89, 3, 11, 21, 18, 43, 43, 61, 71, 18, 82, 14, 35, 100, 50, 54,
                3, 60, 52, 76, 54, 75, 4, 9, 77, 73, 58, 18, 53, 96, 63, 28, 100, 81, 66, 94, 66, 27, 3, 37, 53, 16 };
        iterator = new RandomIteratorDividableByFive(nums);
        int counter = 0;

        for (int i : nums) {
            if (i % 5 == 0) {
                counter++;
            }
        }
        assertEquals(15, counter);
        while (iterator.hasNext()) {
            iterator.hasNext();
            iterator.hasNext();
            iterator.hasNext();
            iterator.remove();
            counter--;
        }

        assertEquals(0, counter);
        assertFalse(iterator.hasNext());
        assertTrue(iterator.next().equals(-1));
    }

}
