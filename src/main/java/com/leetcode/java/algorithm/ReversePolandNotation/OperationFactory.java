package com.leetcode.java.algorithm.ReversePolandNotation;

import com.leetcode.java.algorithm.ReversePolandNotation.operator.binary.AddInteger;
import com.leetcode.java.algorithm.ReversePolandNotation.operator.binary.DivideInteger;
import com.leetcode.java.algorithm.ReversePolandNotation.operator.binary.MultiplyInteger;
import com.leetcode.java.algorithm.ReversePolandNotation.operator.binary.SubtractInteger;
import com.leetcode.java.algorithm.ReversePolandNotation.operator.ternary.AddThreeInteger;
import com.leetcode.java.algorithm.ReversePolandNotation.operator.unary.DoubleInteger;
import com.leetcode.java.algorithm.ReversePolandNotation.operator.unary.SquareInteger;

public class OperationFactory {

    private AddInteger addInteger;
    private SubtractInteger subtractInteger;
    private MultiplyInteger multiplyInteger;
    private DivideInteger divideInteger;
    private SquareInteger squareInteger;
    private DoubleInteger doubleInteger;
    private AddThreeInteger addThreeInteger;

    public OperationFactory() {
        // TODO Auto-generated constructor stub
        addInteger = new AddInteger();
        subtractInteger = new SubtractInteger();
        multiplyInteger = new MultiplyInteger();
        divideInteger = new DivideInteger();
        squareInteger = new SquareInteger();
        doubleInteger = new DoubleInteger();
        addThreeInteger = new AddThreeInteger(3);
    }

    public Token<Integer> parseToken(String token) {
        switch (token) {
        case "+":
            return addInteger;
        case "-":
            return subtractInteger;
        case "*":
            return multiplyInteger;
        case "/":
            return divideInteger;
        case "**":
            return squareInteger;
        case "++":
            return doubleInteger;
        case "+++":
            return addThreeInteger;
        default:
            try {
                return new Operand<>(Integer.decode(token));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid Reverse Polish Token Found: " + token, e);
            }
        }
    }

}
