package com.leetcode.java.algorithm.util;

import java.util.HashMap;

public class TrieNode {

    public HashMap<Character, TrieNode> children;
    public boolean isComplete;

    public TrieNode() {
        children = new HashMap<>();
        isComplete = false;
    }

}
