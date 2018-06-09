package com.leetcode.java.algorithm.Mod5Iterator;

import java.util.Iterator;

public class RandomIteratorDividableByFive implements Iterator<Integer> {

    private RandomIterator iterator;
    private int nextElement;

    public RandomIteratorDividableByFive(int[] nums) {
        // TODO Auto-generated constructor stub
        iterator = new RandomIterator(nums);
        nextElement = -1;
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if (nextElement == -1) {
            while (iterator.hasNext()) {
                nextElement = iterator.next();
                if (nextElement % 5 == 0) {
                    return true;
                }
            }
            nextElement = -1;
            return false;
        } else {
            return true;
        }

    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return -1;
        }
        int returnValue = nextElement;
        nextElement = -1;
        return returnValue;
    }

    @Override
    public void remove() {
        next();
    }

}
