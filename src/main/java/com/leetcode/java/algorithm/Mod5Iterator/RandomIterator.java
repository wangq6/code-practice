package com.leetcode.java.algorithm.Mod5Iterator;

import java.util.Iterator;
import java.util.Stack;

public class RandomIterator implements Iterator<Integer> {

    private Stack<Integer> stack;

    public RandomIterator(int[] nums) {
        // TODO Auto-generated constructor stub
        stack = new Stack<>();
        for (int i : nums) {
            stack.push(i);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop();
        } else {
            return null;
        }
    }

}
