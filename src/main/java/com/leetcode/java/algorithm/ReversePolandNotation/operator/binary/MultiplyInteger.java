package com.leetcode.java.algorithm.ReversePolandNotation.operator.binary;

public class MultiplyInteger extends BinaryOperator<Integer>{

    @Override
    protected Integer calc(Integer a, Integer b) {
        return a * b;
    }

}
