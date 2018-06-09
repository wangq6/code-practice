package com.leetcode.java.algorithm.util;

public class SubtreeNode<V> {

    public int parentIndex;
    public V value;
    public boolean valid;
    public boolean visited;

    public SubtreeNode(int parentIndex, V value) {
        this.value = value;
        this.parentIndex = parentIndex;
        valid = true;
        visited = false;
    }
}
