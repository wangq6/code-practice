package com.leetcode.java.algorithm.ReversePolandNotation.operator.binary;

import java.util.Deque;

import com.leetcode.java.algorithm.ReversePolandNotation.Token;

public abstract class BinaryOperator<T> implements Token<T> {

    @Override
    public void process(Deque<T> stack) {
        if (stack == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        if (stack.size() < 2) {
            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        T secondNumber = stack.pop();
        T firstNumber = stack.pop();
        stack.push(calc(firstNumber, secondNumber));
    }

    protected abstract T calc(T a, T b);
}