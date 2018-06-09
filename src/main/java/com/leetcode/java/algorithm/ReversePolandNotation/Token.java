package com.leetcode.java.algorithm.ReversePolandNotation;

import java.util.Deque;

public interface Token<T> {
    void process(Deque<T> stack);
}
