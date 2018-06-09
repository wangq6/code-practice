package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GameOfLifeTest {

    private GameOfLife gameOfLife;

    @Before
    public void setUp() throws Exception {
        gameOfLife = new GameOfLife();
    }

    @Test
    public void testNextGeneration2D() {
        int[][] input = { { 1, 0, 1, 0, 1, 1, 0, 1, 0 }, { 1, 1, 0, 1, 0, 1, 0, 1, 0 }, { 1, 1, 0, 1, 0, 1, 0, 1, 0 },
                { 1, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 0, 1, 0, 1, 0, 1, 1, 0 }, { 0, 1, 1, 0, 1, 0, 1, 1, 0 },
                { 1, 1, 0, 1, 0, 1, 1, 0, 0 } };
        int[][] expected = { { 1, 0, 1, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 0, 1, 0, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1, 1, 1, 1, 0 } };
        gameOfLife.setBoard2D(input);
        gameOfLife.nextGeneration2D();
        int[][] output = gameOfLife.getBoard2D();

        // System.out.println(Arrays.deepToString(output));
        assertTrue(Arrays.deepEquals(output, expected));
    }

    @Test
    public void testNextGeneration1D() {
        int[] input = { 1, 0, 1, 0, 1, 1, 0, 1, 0 };
        int[] firstGen = { 1, 0, 1, 0, 0, 0, 0, 1, 0 };
        int[] secondGen = { 1, 0, 1, 1, 0, 0, 1, 1, 0 };
        int[] thirdGen = { 1, 0, 0, 0, 1, 1, 0, 0, 0 };
        gameOfLife.setBoard1D(input);

        gameOfLife.nextGeneration1D();
        int[] output = gameOfLife.getBoard1D();
        // System.out.println(Arrays.toString(output));
        assertTrue(Arrays.equals(firstGen, output));

        gameOfLife.nextGeneration1D();
        output = gameOfLife.getBoard1D();
        // System.out.println(Arrays.toString(output));
        assertTrue(Arrays.equals(secondGen, output));

        gameOfLife.nextGeneration1D();
        output = gameOfLife.getBoard1D();
        // System.out.println(Arrays.toString(output));
        assertTrue(Arrays.equals(thirdGen, output));
    }

}
