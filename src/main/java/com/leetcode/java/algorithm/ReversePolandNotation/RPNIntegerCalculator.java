package com.leetcode.java.algorithm.ReversePolandNotation;

import java.util.Deque;
import java.util.LinkedList;

public class RPNIntegerCalculator {
    public static int evaluate(String expression) {
        if (expression == null || expression.length() == 0) {
            throw new IllegalArgumentException("Invalid Reverse Polish Expression");
        }

        String[] tokens = expression.split(" ");
        Deque<Integer> stack = new LinkedList<>();
        OperationFactory operationFactory = new OperationFactory();
        for (String token : tokens) {
            operationFactory.parseToken(token).process(stack);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Reverse Polish Notation Provided");
        }
        return stack.poll();
    }
}