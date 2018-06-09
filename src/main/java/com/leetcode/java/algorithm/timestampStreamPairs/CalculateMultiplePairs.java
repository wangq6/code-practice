package com.leetcode.java.algorithm.timestampStreamPairs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CalculateMultiplePairs {

    private List<Double[]> result;
    private List<Queue<Double>> queues;
    private TimestampStream[] timestampStreams;

    public CalculateMultiplePairs(TimestampStream[] timestampStreams) {
        this.timestampStreams = timestampStreams;
        queues = new LinkedList<>();
        for (int i = 0; i < timestampStreams.length; i++) {
            queues.add(new LinkedList<>());
        }
        result = new ArrayList<>();
    }

    public class QueueThread implements Runnable {

        private TimestampStream s;
        private int index;

        private void processValue(Queue<Double> q1, Queue<Double> q2, double value) {
            q1.offer(value);
            while (!q2.isEmpty() && value - q2.peek() >= 1) {
                q2.poll();
            }

            for (double d : q2) {
                if (Math.abs(d - value) < 1) {
                    result.add(new Double[] { value, d });
                }
            }
        }

        public QueueThread(TimestampStream s, int index) {
            this.s = s;
            this.index = index;
        }

        @Override
        public void run() {
            while (true) {
                // synchronized (queues.get(index)) {
                try {
                    double value = s.getNext();
                    synchronized (queues) {
                        for (int i = 0; i < timestampStreams.length; i++) {
                            if (i != index) {
                                System.out.println("Thread " + index + Arrays.deepToString(queues.toArray()));

                                processValue(queues.get(index), queues.get(i), value);
                            }
                        }
                    }
                } catch (Exception e) {
                    // Reaching end of stream
                    System.out.println(e);
                    break;
                }
                // }
            }
        }
    }

    public List<Double[]> getDistanceLessThanOne() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < timestampStreams.length; i++) {
            threads.add(new Thread(new QueueThread(timestampStreams[i], i)));
        }
        for (int i = 0; i < timestampStreams.length; i++) {
            threads.get(i).start();
        }
        for (int i = 0; i < timestampStreams.length; i++) {
            threads.get(i).join();
        }
        return result;
    }
}
