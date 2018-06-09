package com.leetcode.java.algorithm.ReversePolandNotation;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public abstract class Operator<T> implements Token<T> {
    private final int numOfOperand;

    protected Operator(int numOfOperand) {
        this.numOfOperand = numOfOperand;
    }

    @Override
    public void process(Deque<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        if (stack.size() < numOfOperand) {
            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        List<T> valList = new ArrayList<>(numOfOperand);
        for (int i = 0; i < numOfOperand; i++) {
            valList.add(0, stack.pop());
        }
        stack.push(calc(valList));
    }

    public abstract T calc(List<T> vals);
}
