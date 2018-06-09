package com.leetcode.java.algorithm.ReversePolandNotation.operator.binary;

public class SubtractInteger extends BinaryOperator<Integer>{

    @Override
    protected Integer calc(Integer a, Integer b) {
        return a - b;
    }


}
