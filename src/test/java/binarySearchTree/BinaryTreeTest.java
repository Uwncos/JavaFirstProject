package binarySearchTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class BinaryTreeTest {

    @Test
     void testFunctions() {
        BinaryTree newTree = new BinaryTree();
        newTree.insert(8);
        assertEquals(new Node(8).key, newTree.find(8).key);  //find test
        newTree.insert(9);
        assertEquals(new Node(9).key, newTree.find(9).key);
        newTree.insert(5);
        assertEquals(new Node(5).key, newTree.find(5).key);
        newTree.delete(5);
        newTree.delete(8);
        assertNull(newTree.find(8));                              //delete test
        newTree.insert(5);
        newTree.insert(2);
        newTree.insert(7);
        newTree.insert(1);
        newTree.insert(3);
        newTree.insert(8);
    }


    @Test
    void testNeighbours() {
        BinaryTree newTree = new BinaryTree();              //проверка на поиск соседей происходит с помощью List
        newTree.insert(5);                              //в листе 4 элемента: 1 - родитель, 2 - текущий
        newTree.insert(2);                              //3 - левый потомок, 4 - правый потомок;
        newTree.insert(7);                              //Если элемента нет, то место равно 0
        newTree.insert(1);
        newTree.insert(3);
        newTree.insert(8);
        assertEquals(List.of(5, 2, 1, 3), newTree.neighbours(2));
        assertEquals(List.of(7, 8, 0, 0), newTree.neighbours(8));
        assertEquals(List.of(0, 5, 2, 7), newTree.neighbours(5));
    }
}