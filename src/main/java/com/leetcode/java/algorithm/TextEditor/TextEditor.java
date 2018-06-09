package com.leetcode.java.algorithm.TextEditor;

public interface TextEditor {
    void insert(int p1, String s);

    void delete(int p1, int p2);

    void highlight(int p1, int p2);

    void redo() throws Exception;

    void undo() throws Exception;

    void initialize(String str);

    char index(int i);

    void print();
}
