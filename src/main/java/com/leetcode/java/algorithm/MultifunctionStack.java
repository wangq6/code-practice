package com.leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeSet;

import com.leetcode.java.algorithm.util.DoublyLinkedNode;

public class MultifunctionStack {

    private Stack<Integer[]> stack;
    private int size;
    private int sum;
    public TreeSet<Integer> minSet;
    public TreeSet<Integer> maxSet;
    // public PriorityQueue<Integer> minHeap;
    // public PriorityQueue<Integer> maxHeap;
    private HashMap<Integer, Integer> freqMap;
    private List<HashSet<Integer>> freqList;

    public MultifunctionStack() {
        // TODO Auto-generated constructor stub
        stack = new Stack<>();
        size = 0;
        sum = 0;
        minSet = new TreeSet<>();
        maxSet = new TreeSet<>();
        // minHeap = new PriorityQueue<>();
        // maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
        // @Override
        // public int compare(Integer x, Integer y) {
        // return y - x;
        // }
        // });
        freqList = new ArrayList<>();
        freqList.add(new HashSet<>());
        freqMap = new HashMap<>();
    }

    public int pop() {
        if (size == 0) {
            return -1;
        }
        int removed = stack.pop()[0];
        size--;
        sum -= removed;

        // Remove from median finder
        // if (removed <= maxHeap.peek()) {
        // maxHeap.remove(removed);
        // if (maxHeap.size() < minHeap.size()) {
        // maxHeap.offer(minHeap.poll());
        // }
        // } else {
        // minHeap.remove(removed);
        // if (maxHeap.size() - 1 > minHeap.size()) {
        // minHeap.offer(maxHeap.poll());
        // }
        // }

        // Remove from median finder
        if (removed <= minSet.last()) {
            minSet.remove(removed);
            if (minSet.size() < maxSet.size()) {
                minSet.add(maxSet.first());
                maxSet.remove(maxSet.first());
            }
        } else {
            maxSet.remove(removed);
            if (minSet.size() - 1 > maxSet.size()) {
                maxSet.add(minSet.last());
                minSet.remove(minSet.last());
            }
        }

        // Remove from freq finder
        int freq = freqMap.get(removed);
        if (freq - 1 > 0) {
            freqList.get(freq - 1).remove(removed);
            freqList.get(freq - 2).add(removed);
            freqMap.put(removed, freq - 1);
        } else {
            freqList.get(freq - 1).remove(removed);
            freqMap.remove(removed);
        }

        return removed;
    }

    public void push(int val) {
        if (size == 0) {
            stack.push(new Integer[] { val, val, val });
            size++;
            sum += val;
        } else {
            Integer[] last = stack.peek();
            Integer[] turple = new Integer[] { val, last[1], last[2] };
            if (val < last[1]) {
                turple[1] = val;
            }
            if (val > last[2]) {
                turple[2] = val;
            }

            stack.push(turple);
            size++;
            sum += val;
        }

        // Add to median finder
        minSet.add(val);
        maxSet.add(minSet.last());
        minSet.remove(minSet.last());
        if (minSet.size() < maxSet.size()) {
            minSet.add(maxSet.first());
            maxSet.remove(maxSet.first());
        }
        // // Add to median finder
        // maxHeap.offer(val);
        // minHeap.offer(maxHeap.poll());
        // if (maxHeap.size() < minHeap.size()) {
        // maxHeap.offer(minHeap.poll());
        // }

        // Add to freq finder
        if (!freqMap.containsKey(val)) {
            freqList.get(0).add(val);
            freqMap.put(val, 1);
        } else {
            int freq = freqMap.get(val);
            freqList.get(freq - 1).remove(val);

            freqMap.put(val, freq + 1);

            if (freq + 1 <= freqList.size()) {
                freqList.get(freq).add(val);
            } else {
                freqList.add(new HashSet<>(Arrays.asList(val)));
            }
        }

    }

    public int getMin() {
        if (size == 0) {
            return -1;
        } else {
            return stack.peek()[1];
        }
    }

    public int getMax() {
        if (size == 0) {
            return -1;
        } else {
            return stack.peek()[2];
        }
    }

    public int getAveage() {
        if (size == 0) {
            return -1;
        } else {
            return sum / size;
        }
    }

    public double getMedian() {
        if (size == 0) {
            return -1;
        } else if (size % 2 == 0) {
            return (minSet.last() + maxSet.first()) * 0.5;
        } else {
            return minSet.last();
        }
    }

    public int getMostFreq() throws Exception {

        if (size == 0) {
            return -1;
        } else {
            int end = freqList.size() - 1;
            while (freqList.get(end).size() == 0) {
                end--;
            }
            if (end < 0) {
                throw new Exception("Null freqList");
            } else {
                return freqList.get(end).iterator().next();
            }
        }
    }
}
