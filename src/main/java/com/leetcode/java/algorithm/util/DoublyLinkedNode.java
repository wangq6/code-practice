package com.leetcode.java.algorithm.util;

public class DoublyLinkedNode<V> {

    public V value;
    public DoublyLinkedNode<V> pre;
    public DoublyLinkedNode<V> next;

    public DoublyLinkedNode() {
    }

    public DoublyLinkedNode(V value) {
        this.value = value;
    }


}
