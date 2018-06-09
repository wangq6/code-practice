package com.leetcode.java.algorithm.TextEditor;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextEditorTest {

    private TextEditor textEditor;
    @Before
    public void setUp() throws Exception {
        textEditor = new TextEditorImpl();
    }

    @Test
    public void test() throws Exception {
        textEditor.initialize("abc dfg beg qer");
        textEditor.print();
        System.out.println(textEditor.index(0));
        System.out.println(textEditor.index(1));
        System.out.println(textEditor.index(2));
        System.out.println(textEditor.index(3));
        System.out.println(textEditor.index(4));
        System.out.println(textEditor.index(5));
        System.out.println(textEditor.index(6));
        System.out.println(textEditor.index(7));
        System.out.println(textEditor.index(8));
        System.out.println(textEditor.index(9));
        System.out.println(textEditor.index(10));
        System.out.println(textEditor.index(11));
        textEditor.insert(2, "sss ");
        textEditor.print();
//        textEditor.insert(8, "beg ");
//        textEditor.print();
//        textEditor.insert(12, "wrt");
//        textEditor.print();
//        textEditor.insert(5, "t  hahahahha t");
//        textEditor.print();
//        textEditor.delete(9, 13);
//        textEditor.print();
//        textEditor.redo();
//        textEditor.print();
//        textEditor.redo();
//        textEditor.print();
//        textEditor.undo();
//        textEditor.print();
//        textEditor.undo();
//        textEditor.print();
    }

}
