package com.leetcode.java.algorithm.ReversePolandNotation;

import java.util.Deque;

public class Operand<T> implements Token<T> {
    private final T val;

    public Operand(T val) {
        this.val = val;
    }

    @Override
    public void process(Deque<T> stack) {
        stack.push(val);
    }
}