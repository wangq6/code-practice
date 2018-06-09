package com.leetcode.java.algorithm.ReversePolandNotation.operator.unary;

import java.util.Deque;

import com.leetcode.java.algorithm.ReversePolandNotation.Token;

public abstract class UnaryOperator<T> implements Token<T> {

    @Override
    public void process(Deque<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        if (stack.size() < 1) {
            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        T firstNumber = stack.pop();
        stack.push(calc(firstNumber));
    }

    protected abstract T calc(T a);
}