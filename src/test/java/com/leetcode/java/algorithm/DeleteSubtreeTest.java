package com.leetcode.java.algorithm;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.leetcode.java.algorithm.util.SubtreeNode;

public class DeleteSubtreeTest {

    private DeleteSubtree<Character> deleteSubtree;

    @Before
    public void setUp() throws Exception {
        SubtreeNode<Character> A = new SubtreeNode<>(-1, 'A');
        SubtreeNode<Character> B = new SubtreeNode<>(4, 'B');
        SubtreeNode<Character> C = new SubtreeNode<>(1, 'C');
        SubtreeNode<Character> D = new SubtreeNode<>(1, 'D');
        SubtreeNode<Character> E = new SubtreeNode<>(6, 'E');
        SubtreeNode<Character> F = new SubtreeNode<>(5, 'F');
        SubtreeNode<Character> G = new SubtreeNode<>(3, 'G');
        SubtreeNode<Character> H = new SubtreeNode<>(2, 'H');
        SubtreeNode<Character> I = new SubtreeNode<>(9, 'I');
        SubtreeNode<Character> J = new SubtreeNode<>(7, 'J');
        SubtreeNode<Character> K = new SubtreeNode<>(6, 'K');
        SubtreeNode<Character> L = new SubtreeNode<>(3, 'L');
        SubtreeNode<Character> M = new SubtreeNode<>(2, 'M');
        SubtreeNode<Character> N = new SubtreeNode<>(10, 'N');
        deleteSubtree = new DeleteSubtree<>(new SubtreeNode[] { C, B, G, D, A, F, E, H, M, N, J, K, L, I });
        // A -> B -> C   B -> D -> G -> H -> J -> N -> I       F    E -> K     G -> M      D -> L   
    }

    @Test
    public void testRemoveD() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtree(3);
        assertEquals(6, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtree(3);
        assertEquals(6, deleteSubtree.getCapacity());
    }
    
    @Test
    public void testRemoveA() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtree(4);
        assertEquals(3, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtree(4);
        assertEquals(3, deleteSubtree.getCapacity());
    }
    
    @Test
    public void testRemoveF() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove F
        deleteSubtree.deleteSubtree(5);
        assertEquals(13, deleteSubtree.getCapacity());
        // Remove F
        deleteSubtree.deleteSubtree(5);
        assertEquals(13, deleteSubtree.getCapacity());
    }
    
    @Test
    public void testRemoveDThenA() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtree(3);
        assertEquals(6, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtree(3);
        assertEquals(6, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtree(4);
        assertEquals(3, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtree(4);
        assertEquals(3, deleteSubtree.getCapacity());
    }

    @Test
    public void testRemoveDWithoutVisited() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtreeWithoutVisited(3);
        assertEquals(6, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtreeWithoutVisited(3);
        assertEquals(6, deleteSubtree.getCapacity());
    }
    
    @Test
    public void testRemoveAWithoutVisited() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtreeWithoutVisited(4);
        assertEquals(3, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtreeWithoutVisited(4);
        assertEquals(3, deleteSubtree.getCapacity());
    }
    
    @Test
    public void testRemoveFWithoutVisited() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove F
        deleteSubtree.deleteSubtreeWithoutVisited(5);
        assertEquals(13, deleteSubtree.getCapacity());
        // Remove F
        deleteSubtree.deleteSubtreeWithoutVisited(5);
        assertEquals(13, deleteSubtree.getCapacity());
    }
    
    @Test
    public void testRemoveDThenAWithoutVisited() throws Exception {
        assertEquals(14, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtreeWithoutVisited(3);
        assertEquals(6, deleteSubtree.getCapacity());
        // Remove D
        deleteSubtree.deleteSubtreeWithoutVisited(3);
        assertEquals(6, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtreeWithoutVisited(4);
        assertEquals(3, deleteSubtree.getCapacity());
        // Remove A
        deleteSubtree.deleteSubtreeWithoutVisited(4);
        assertEquals(3, deleteSubtree.getCapacity());
    }
}
