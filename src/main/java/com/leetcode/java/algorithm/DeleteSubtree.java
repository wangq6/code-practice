package com.leetcode.java.algorithm;

import java.util.HashSet;

import com.leetcode.java.algorithm.util.SubtreeNode;

public class DeleteSubtree<V> {

    private SubtreeNode<V>[] nodes;
    private int capacity;

    public DeleteSubtree(SubtreeNode<V>[] nodes) {
        capacity = nodes.length;
        this.nodes = nodes;
    }

    public int getCapacity() {
        return capacity;
    }

    public SubtreeNode<V>[] getNodesy() {
        return nodes;
    }

    public void deleteSubtree(int index) throws Exception {
        if (index < 0 || index >= nodes.length) {
            throw new Exception("Invalid index");
        }
        if (!nodes[index].valid) {
            return;
        }

        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].valid) {
                nodes[i].visited = false;
            }
        }

        nodes[index].valid = false;
        capacity--;
        nodes[index].visited = true;
        for (int i = 0; i < nodes.length; i++) {
            if (!nodes[i].visited) {
                search(i);
            }
        }
    }

    private boolean search(int index) {
        if (!nodes[index].valid) {
            return false;
        }

        if (nodes[index].parentIndex == -1 || nodes[index].visited) {
            nodes[index].visited = true;
            return nodes[index].valid;
        }
        nodes[index].visited = true;
        nodes[index].valid = search(nodes[index].parentIndex);
        if (!nodes[index].valid) {
            capacity--;
        }
        return nodes[index].valid;
    }

    // Could also add pointer for child and sibling nodes to solve
    public void deleteSubtreeWithoutVisited(int index) throws Exception {
        if (index < 0 || index >= nodes.length) {
            throw new Exception("Invalid index");
        }
        if (!nodes[index].valid) {
            return;
        }

        HashSet<V> visited = new HashSet<>();
        nodes[index].valid = false;
        capacity--;
        visited.add(nodes[index].value);
        for (int i = 0; i < nodes.length; i++) {
            if (!visited.contains(nodes[i].value)) {
                searchWithoutVisited(i, visited);
            }
        }
    }

    private boolean searchWithoutVisited(int index, HashSet<V> visited) {
        if (!nodes[index].valid) {
            return false;
        }

        if (nodes[index].parentIndex == -1 || visited.contains(nodes[index].value)) {
            visited.add(nodes[index].value);
            return nodes[index].valid;
        }
        visited.add(nodes[index].value);
        nodes[index].valid = searchWithoutVisited(nodes[index].parentIndex, visited);
        if (!nodes[index].valid) {
            capacity--;
        }
        return nodes[index].valid;
    }

}
