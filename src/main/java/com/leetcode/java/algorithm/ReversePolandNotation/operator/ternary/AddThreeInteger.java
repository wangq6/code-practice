package com.leetcode.java.algorithm.ReversePolandNotation.operator.ternary;

import java.util.List;

public class AddThreeInteger extends TernaryOperator<Integer> {

    public AddThreeInteger(int numOfOperands) {
        super(numOfOperands);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected Integer calc(List<Integer> nums) {
        // TODO Auto-generated method stub
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            result += nums.get(i);
        }
        return result;
    }

}
