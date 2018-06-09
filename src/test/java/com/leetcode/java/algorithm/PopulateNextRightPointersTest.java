package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.java.algorithm.util.TreeLinkNode;

public class PopulateNextRightPointersTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        TreeLinkNode root = new TreeLinkNode(0);
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node10 = new TreeLinkNode(10);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.left = node6;
        node4.right = node7;
        node5.left = node8;
        node5.right = node9;
        node7.left = node10;

        PopulateNextRightPointers.connect(root);
        assertEquals(null, root.next);
        assertEquals(node2, node1.next);
        assertEquals(null, node2.next);
        assertEquals(node4, node3.next);
        assertEquals(node5, node4.next);
        assertEquals(null, node5.next);
        assertEquals(node7, node6.next);
        assertEquals(node8, node7.next);
        assertEquals(node9, node8.next);
        assertEquals(null, node9.next);
        assertEquals(null, node10.next);

    }

}
