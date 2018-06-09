package com.leetcode.java.algorithm.util;

public class LinkedNode<K, V> {

    public K key;
    public V value;
    public LinkedNode<K, V> next;

    public LinkedNode() {
    }

    public LinkedNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

}
