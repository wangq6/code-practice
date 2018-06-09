package com.leetcode.java.algorithm;

public class WildcardMatch {
    public static boolean isMatch(String str, String pattern) {
        int s = 0;
        int p = 0;
        int match = 0;
        int starIdx = -1;
        while (s < str.length()) {
            if (p < pattern.length() && (str.charAt(s) == pattern.charAt(p) || pattern.charAt(p) == '?')) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '*') {
                starIdx = p;
                match = s;
                p++;
            } else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            } else {
                return false;
            }
        }

        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }

        return p == pattern.length();
    }

    public static boolean isMatchDp(String str, String pattern) {
        boolean[][] dp = new boolean[str.length() + 1][pattern.length() + 1];
        dp[0][0] = true;
        for (int j = 0; j < pattern.length(); j++) {
            if (pattern.charAt(j) == '*') {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (str.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (pattern.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j] || dp[i][j + 1] || dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }
        return dp[str.length()][pattern.length()];
    }

    public static boolean isMatchRecursive(String str, String pattern) {
        if (str.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (str.length() == 0 && pattern.length() != 0) {
            return pattern.replace("*", "").length() == 0;
        }
        if (str.length() != 0 && pattern.length() == 0) {
            return false;
        }

        if (str.charAt(str.length() - 1) == pattern.charAt(pattern.length() - 1)
                || pattern.charAt(pattern.length() - 1) == '?') {
            return isMatchRecursive(str.substring(0, str.length() - 1), pattern.substring(0, pattern.length() - 1));
        }

        if (pattern.charAt(pattern.length() - 1) == '*') {
            return isMatchRecursive(str.substring(0, str.length() - 1), pattern.substring(0, pattern.length() - 1))
                    || isMatchRecursive(str.substring(0, str.length() - 1), pattern)
                    || isMatchRecursive(str, pattern.substring(0, pattern.length() - 1));
        }
        return false;
    }
}
