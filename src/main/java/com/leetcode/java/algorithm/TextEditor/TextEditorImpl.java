package com.leetcode.java.algorithm.TextEditor;

import java.util.Stack;

import com.leetcode.java.algorithm.util.TextEditorTreeNode;

public class TextEditorImpl implements TextEditor {

    private TextEditorTreeNode root;
    private Stack<EditAction> redoStack;
    private Stack<EditAction> undoStack;

    public enum EditType {
        INSERT, DELETE;
    }

    public class EditAction {
        public EditType type;
        public int delete_i;
        public int delete_j;
        public String insert;

        public EditAction(EditType type, int delete_i, int delete_j, String insert) {
            this.type = type;
            this.delete_i = delete_i;
            this.delete_j = delete_j;
            this.insert = insert;
        }
    }

    public TextEditorImpl() {
        redoStack = new Stack<>();
        undoStack = new Stack<>();
    }

    /** Function to clear rope **/
    public void makeEmpty() {
        root = null;
    }

    @Override
    public void initialize(String str) {
        String[] strings = str.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (i + 1 < strings.length) {
                concat(new TextEditorTreeNode(strings[i] + " "));
            } else {
                concat(new TextEditorTreeNode(strings[i]));
            }
        }
    }

    /** Function to concat an element **/
    private void concat(TextEditorTreeNode newNode) {
        if (root == null) {
            root = newNode;
            return;
        }

        TextEditorTreeNode newRoot = new TextEditorTreeNode();
        newRoot.left = root;
        newRoot.right = newNode;
        newRoot.weight = newRoot.left.weight + newNode.weight;
        root = newRoot;
    }

    /** Function to concat an element **/
    private TextEditorTreeNode split(int ind) {
        if (root == null || ind >= root.weight) {
            return root;
        }
        TextEditorTreeNode returnNode = new TextEditorTreeNode();
        TextEditorTreeNode curReturnNode = returnNode;

        TextEditorTreeNode tmp = root;
        while (tmp.data == null) {
            if (tmp.left != null && ind < tmp.left.weight) {
                tmp.weight -= ind;
                curReturnNode.weight = ind;
                curReturnNode.right = tmp.right;
                curReturnNode.left = tmp.left;
                tmp.right = null;
                curReturnNode = curReturnNode.left;
                tmp = tmp.left;
            } else {
                tmp.weight -= ind;
                if (tmp.left != null) {
                    ind -= tmp.left.weight;
                }
                curReturnNode.weight = ind;
                curReturnNode.right = tmp.right;
                curReturnNode = curReturnNode.right;
                tmp = tmp.right;
            }
        }

        if (ind == 0) {
            curReturnNode.left = new TextEditorTreeNode(tmp.data);
            tmp.data = null;
            tmp.weight = 0;
        } else if (ind == tmp.weight) {
            returnNode.left = null;
            returnNode = returnNode.right;
        } else {
            TextEditorTreeNode node_left = new TextEditorTreeNode(tmp.data.substring(0, ind));
            TextEditorTreeNode node_right = new TextEditorTreeNode(tmp.data.substring(ind));
            tmp.data = null;
            tmp.left = node_left;
            curReturnNode.right = node_right;
        }

        return returnNode;
    }

    /** Function get character at a paricular index **/
    @Override
    public char index(int ind) {
        int copy = ind;
        TextEditorTreeNode tmp = root;
        while (tmp.data == null) {
            if (tmp.left != null && ind < tmp.left.weight) {
                tmp = tmp.left;
            } else {
                if (tmp.left != null) {
                    ind -= tmp.left.weight;
                }
                tmp = tmp.right;
            }
        }
        if (ind >= tmp.weight) {
            ind = tmp.weight - 1;
        }
        System.out.println("Need idx of " + copy + " get from data " + tmp.data);
        return tmp.data.charAt(ind);
    }

    @Override
    public void insert(int p1, String s) {
        TextEditorTreeNode newNode = new TextEditorTreeNode(s);
        TextEditorTreeNode lastNode = split(p1);
        concat(newNode);
        concat(lastNode);
        undoStack.push(new EditAction(EditType.DELETE, p1, p1 + s.length(), s));
    }

    @Override
    public void delete(int p1, int p2) {
        if (p1 >= p2) {
            return;
        }
        TextEditorTreeNode lastNode = split(p2);
        TextEditorTreeNode deleteNode = split(p1);
        concat(lastNode);
        undoStack.push(new EditAction(EditType.INSERT, p1, p2, print(deleteNode)));
    }

    @Override
    public void highlight(int p1, int p2) {
        // TODO Auto-generated method stub

    }

    @Override
    public void redo() throws Exception {
        // TODO Auto-generated method stub
        EditAction action = redoStack.pop();
        switch (action.type) {
        case INSERT:
            delete(action.delete_i, action.delete_j);
            break;
        case DELETE:
            insert(action.delete_i, action.insert);
            break;
        default:
            throw new Exception("Invalid Redo Type");
        }
    }

    @Override
    public void undo() throws Exception {
        // TODO Auto-generated method stub
        EditAction action = undoStack.pop();
        redoStack.push(action);
        switch (action.type) {
        case INSERT:
            insert(action.delete_i, action.insert);
            break;
        case DELETE:
            delete(action.delete_i, action.delete_j);
            break;
        default:
            throw new Exception("Invalid Undo Type");
        }
        undoStack.pop();
    }

    /** Function to print Rope **/
    @Override
    public void print() {
        System.out.println(print(root));
    }

    private String print(TextEditorTreeNode r) {
        String s = "";
        if (r != null) {
            s = s + print(r.left);
            if (r.data != null)
                s = s + r.data;
            s = s + print(r.right);
        }
        return s;
    }
}
