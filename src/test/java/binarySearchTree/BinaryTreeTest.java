package binarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
//    BinaryTree newTree = new BinaryTree();
//    @BeforeEach
//    void setUp() throws Exception {
//        newTree.insert(7);
//        newTree.insert(5);
//        newTree.insert(8);
//        newTree.insert(7);
//        newTree.insert(9);
//        newTree.insert(3);
//        newTree.insert(4);
//        newTree.insert(11);
//        newTree.insert(10);
//    }
    @Test
     void testFind() {
        BinaryTree newTree = new BinaryTree();
        newTree.insert(8);
        assertEquals(new Node(8).key, newTree.find(8).key);
        newTree.insert(9);
        assertEquals(new Node(9).key, newTree.find(9).key);
        newTree.insert(5);
        assertEquals(new Node(5).key, newTree.find(5).key);
        newTree.insert(8);                                        //illegalArgument test
        newTree.delete(5);
        newTree.delete(8);
        assertNull(newTree.find(8));
    }

    @Test
    void testInsert() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testGetMove() {
    }
}