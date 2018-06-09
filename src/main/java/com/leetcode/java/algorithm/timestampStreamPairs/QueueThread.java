package com.leetcode.java.algorithm.timestampStreamPairs;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class QueueThread implements Runnable {

    private TimestampStream s;
    private BlockingQueue<Double> queue1;
    private BlockingQueue<Double> queue2;
    private List<Double[]> result;

    private void processValue(double value) throws InterruptedException {
        queue1.put(value);
        while (!queue2.isEmpty() && value - queue2.peek() >= 1) {
            queue2.take();
        }

        for (double d : queue2) {
            if (Math.abs(d - value) < 1) {
                result.add(new Double[] { value, d });
            }
        }
    }

    public QueueThread(TimestampStream s, BlockingQueue<Double> queue1, BlockingQueue<Double> queue2,
            List<Double[]> result) {
        this.s = s;
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.result = result;
    }

    @Override
    public void run() {
        while (true) {
            try {
                double value = s.getNext();
                System.out.println(Arrays.deepToString(queue1.toArray()));
                synchronized (queue1) {
                    synchronized (queue2) {
                        processValue(value);
                    }
                }
            } catch (Exception e) {
                // Reaching end of stream
                System.out.println(e.getMessage());
                break;
            }
        }
    }

}