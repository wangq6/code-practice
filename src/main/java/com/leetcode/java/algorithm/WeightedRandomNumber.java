package com.leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WeightedRandomNumber<T> {

    private int total;
    private Map<T, Integer> weightMap;
    private Random rand;

    public WeightedRandomNumber() {
        total = 0;
        weightMap = new HashMap<>();
        rand = new Random();
    }

    public void put(T key, int weight) {
        total = total + weight - weightMap.getOrDefault(key, 0);
        weightMap.put(key, weight);
    }

    public T fetch() {
        int cur = rand.nextInt(total);
        for (Map.Entry<T, Integer> entry : weightMap.entrySet()) {
            cur -= entry.getValue();
            if (cur < 0) {
                return entry.getKey();
            }
        }
        return null;
    }

//    private int total;
//    private List<T> weightList;
//    private Random rand;
//
//    public WeightedRandomNumber() {
//        total = 0;
//        weightList = new ArrayList<>();
//        rand = new Random();
//    }
//
//    public void put(T key, int weight) {
//        int cur = weight;
//        while (cur > 0) {
//            weightList.add(key);
//            cur--;
//        }
//        total += weight;
//    }
//
//    public T fetch() {
//        int cur = rand.nextInt(total);
//        return weightList.get(cur);
//    }
}
