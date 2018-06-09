package com.leetcode.java.algorithm.ReversePolandNotation.operator.ternary;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.leetcode.java.algorithm.ReversePolandNotation.Token;

public abstract class TernaryOperator<T> implements Token<T> {

    private int numOfOperands;

    protected TernaryOperator(int numOfOperands) {
        this.numOfOperands = numOfOperands;
    }

    @Override
    public void process(Deque<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        if (stack.size() < numOfOperands) {
            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        List<T> nums = new ArrayList<>();
        for (int i = 0; i < numOfOperands; i++) {
            nums.add(stack.pop());
        }

        stack.push(calc(nums));
    }

    protected abstract T calc(List<T> nums);
}