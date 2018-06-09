package com.leetcode.java.algorithm.timestampStreamPairs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class CalculatePairs {

    public static List<Double[]> getDistanceLessThanOne(TimestampStream s1, TimestampStream s2) throws InterruptedException {
        BlockingQueue<Double> queue1 = new LinkedBlockingDeque<>();
        BlockingQueue<Double> queue2 = new LinkedBlockingDeque<>();
        List<Double[]> result = new ArrayList<>();

        Thread t1 = new Thread(new QueueThread(s1, queue1, queue2, result));
        Thread t2 = new Thread(new QueueThread(s2, queue2, queue1, result));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return result;
    }
}
