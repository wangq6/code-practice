package com.leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.java.algorithm.util.TrieNode;

public class SubstringWordSearch {

    private TrieNode root;

    public SubstringWordSearch() {
        root = new TrieNode();
    }

    public void addWords(String[] dictionary) {
        for (int i = 0; i < dictionary.length; i++) {
            insert(dictionary[i]);
        }
    }

    public List<String> search(String target) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < target.length(); i++) {
            TrieNode node = root;
            StringBuilder sb = new StringBuilder();
            int cur = i;
            char c = target.charAt(cur);

            while (node.children.containsKey(c)) {
                node = node.children.get(c);
                sb.append(c);
                if (node.isComplete) {
                    result.add(sb.toString());
                }
                cur++;
                c = target.charAt(cur);
            }
        }
        return result;
    }

    private void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }

        node.isComplete = true;
    }

}
