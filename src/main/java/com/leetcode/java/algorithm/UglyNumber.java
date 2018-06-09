package com.leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
    public static List<Integer> getUglyNumberSmallerThanN(int N, int a, int b) {
        List<Integer> result = new ArrayList<>();

        int posA = -1;
        int posB = -1;
        int curA = a;
        int curB = b;
        int curMin = Math.min(curA, curB);
        ;
        while (curMin < N) {
            if (posA == -1) {
                curA = a;
            } else {
                curA = a * result.get(posA);
            }

            if (posB == -1) {
                curB = b;
            } else {
                curB = b * result.get(posB);
            }

            curMin = Math.min(curA, curB);
            if (curMin >= N) {
                break;
            } else {
                result.add(curMin);
            }

            if (curMin == curA) {
                posA++;
            }
            if (curMin == curB) {
                posB++;
            }
        }
        return result;
    }
}
