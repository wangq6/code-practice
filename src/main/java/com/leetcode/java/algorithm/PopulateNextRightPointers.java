package com.leetcode.java.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.java.algorithm.util.TreeLinkNode;

public class PopulateNextRightPointers {

    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        root.next = null;
        List<TreeLinkNode> cur = new ArrayList<>();
        cur.add(root);
        while (cur.size() > 0) {
            List<TreeLinkNode> level = new ArrayList<>();
            TreeLinkNode preNode = null;
            
            for (TreeLinkNode node : cur) {
                if (preNode == null) {
                    preNode = node;
                } else {
                    preNode.next = node;
                    preNode = node;
                }
                
                if (node.left != null) {
                    level.add(node.left);
                }
                
                if (node.right != null) {
                    level.add(node.right);
                }
            }
            
            preNode.next = null;
            cur = level;
        }
    }
}
