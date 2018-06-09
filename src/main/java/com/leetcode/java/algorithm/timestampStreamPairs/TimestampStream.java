package com.leetcode.java.algorithm.timestampStreamPairs;

import java.util.List;

public class TimestampStream {
    private List<Double> numbers;
    private int index;

    public TimestampStream(List<Double> numbers) {
        this.numbers = numbers;
        index = 0;
    }

    public double getNext() throws Exception {
        if (index < numbers.size()) {
            index++;
            return numbers.get(index - 1);
        } else {
            throw new Exception("Reaching end of stream");
        }
    }
}
