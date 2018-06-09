package com.leetcode.java.algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) * 0.5;
        } else {
            return maxHeap.peek();
        }
    }
}
