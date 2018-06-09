package com.leetcode.java.algorithm.util;

public class TextEditorTreeNode {

    public TextEditorTreeNode left;
    public TextEditorTreeNode right;
    public int weight;
    public String data;

    public TextEditorTreeNode() {
        // TODO Auto-generated constructor stub
        weight = 0;
        data = null;
    }
    
    public TextEditorTreeNode(String data) {
        // TODO Auto-generated constructor stub
        weight = data.length();
        this.data = data;
    }

}
