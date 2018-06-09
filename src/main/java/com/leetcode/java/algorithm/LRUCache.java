package com.leetcode.java.algorithm;

import java.util.HashMap;

import com.leetcode.java.algorithm.util.LinkedNode;

public class LRUCache {

    private int capacity;

    private LinkedNode<String, String> head;
    private HashMap<String, LinkedNode<String, String>> hashMap;
    private LinkedNode<String, String> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode<>();
        hashMap = new HashMap<>();
        tail = head;
    }

    public String get(String key) {
        if (!hashMap.containsKey(key)) {
            return null;
        }
        kick(hashMap.get(key));
        return hashMap.get(key).next.value;
    }

    public void put(String key, String value) {
        if (!hashMap.containsKey(key)) {
            pushBack(new LinkedNode<String, String>(key, value));
            if (hashMap.size() > capacity) {
                popFront();
            }
        } else {
            kick(hashMap.get(key));
            hashMap.get(key).value = value;
        }
    }

    private void pushBack(LinkedNode<String, String> node) {
        hashMap.put(node.key, tail);
        tail.next = node;
        tail = node;
    }

    private void popFront() {
        hashMap.remove(head.next.key);
        head.next = head.next.next;
        hashMap.put(head.next.key, head);
    }

    private void kick(LinkedNode<String, String> prev) {
        LinkedNode<String, String> node = prev.next;
        if (node == tail) {
            return;
        }
        prev.next = node.next;
        if (node.next != null) {
            hashMap.put(node.next.key, prev);
        }
        pushBack(node);
    }
}
