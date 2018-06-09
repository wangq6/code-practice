package com.leetcode.java.algorithm;

public class MedianOfTwoSortedArrays {

    public static double findMedian(int[] A, int[] B) {
        int n = A.length + B.length;
        if (n == 0) {
            return 0;
        }

        if (n % 2 == 0) {
            return (findKth(A, B, n / 2) + findKth(A, B, n / 2 + 1)) / 2.0;
        }

        return findKth(A, B, n / 2 + 1);
    }

    private static int findKth(int[] A, int[] B, int k) {
        if (A.length == 0) {
            return B[k - 1];
        }
        if (B.length == 0) {
            return A[k - 1];
        }

        int start = Math.min(A[0], B[0]);
        int end = Math.max(A[A.length - 1], B[B.length - 1]);

        // find first x that >= k numbers is smaller or equal to x
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (countSmallerOrEqual(A, mid) + countSmallerOrEqual(B, mid) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (countSmallerOrEqual(A, start) + countSmallerOrEqual(B, start) >= k) {
            return start;
        }

        return end;
    }

    private static int countSmallerOrEqual(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] > target) {
            return start;
        }

        if (nums[end] > target) {
            return end;
        }

        return nums.length;
    }
}
