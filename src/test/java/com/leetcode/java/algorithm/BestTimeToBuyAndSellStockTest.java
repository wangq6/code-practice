package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BestTimeToBuyAndSellStockTest {

    private int[] prices;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        // Array Length 200
        prices = new int[] { 5, 25, 16, 20, 2, 21, 27, 22, 3, 23, 16, 10, 4, 30, 9, 4, 19, 17, 10, 25, 18, 7, 9, 18, 21,
                10, 4, 14, 30, 24, 7, 4, 3, 4, 29, 12, 11, 30, 28, 18, 13, 6, 13, 13, 27, 19, 11, 17, 25, 23, 15, 20,
                20, 22, 16, 30, 13, 4, 7, 25, 29, 24, 12, 12, 10, 26, 12, 22, 13, 17, 9, 16, 30, 18, 14, 18, 8, 25, 30,
                25, 18, 10, 12, 21, 16, 9, 27, 29, 17, 3, 19, 15, 25, 1, 11, 17, 25, 19, 6, 13, 5, 25, 16, 20, 2, 21,
                27, 22, 3, 23, 16, 10, 4, 30, 9, 4, 19, 17, 10, 25, 18, 7, 9, 18, 21, 10, 4, 14, 30, 24, 7, 4, 3, 4, 29,
                12, 11, 30, 28, 18, 13, 6, 13, 13, 27, 19, 11, 17, 25, 23, 15, 20, 20, 22, 16, 30, 13, 4, 7, 25, 29, 24,
                12, 12, 10, 26, 12, 22, 13, 17, 9, 16, 30, 18, 14, 18, 8, 25, 30, 25, 18, 10, 12, 21, 16, 9, 27, 29, 17,
                3, 19, 15, 25, 1, 11, 17, 25, 19, 6, 1 };
        assertEquals(29, BestTimeToBuyAndSellStock.maxProfitOneTransaction(prices));
        assertEquals(905, BestTimeToBuyAndSellStock.maxProfitUnlimitedTransaction(prices));
        assertEquals(57, BestTimeToBuyAndSellStock.maxProfitTwoTransaction(prices));
        assertEquals(263, BestTimeToBuyAndSellStock.maxProfitKTransaction(10, prices));
        assertEquals(380, BestTimeToBuyAndSellStock.maxProfitKTransaction(15, prices));
        assertEquals(488, BestTimeToBuyAndSellStock.maxProfitKTransaction(20, prices));
        assertEquals(588, BestTimeToBuyAndSellStock.maxProfitKTransaction(25, prices));
        assertEquals(885, BestTimeToBuyAndSellStock.maxProfitKTransaction(50, prices));
        assertEquals(905, BestTimeToBuyAndSellStock.maxProfitKTransaction(55, prices));
        assertEquals(905, BestTimeToBuyAndSellStock.maxProfitKTransaction(60, prices));
    }
}
