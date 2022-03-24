package binarySearchTree;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class BinaryTreeTest {

    @Test
     void testFunctions() {
        BinaryTree newTree = new BinaryTree();
        newTree.insert(8);
        assertEquals(8, newTree.find(8).getKey());  //find test
        newTree.insert(9);
        assertEquals(9, newTree.find(9).getKey());
        newTree.insert(5);
        assertEquals(5, newTree.find(5).getKey());

        newTree.delete(5);
        newTree.delete(8);
        assertNull(newTree.find(8));                              //delete test
        newTree.delete(8);                                        //second delete test
    }


    @Test
    void testFunctions2() {
        BinaryTree newTree = new BinaryTree();              //проверка на поиск соседей происходит с помощью List
        newTree.insert(5);                              //в листе 4 элемента: 1 - родитель, 2 - текущий
        newTree.insert(2);                              //3 - левый потомок, 4 - правый потомок;
        newTree.insert(7);                              //Если элемента нет, то место равно 0
        newTree.insert(1);
        newTree.insert(3);
        newTree.insert(8);
        assertEquals(List.of("5", "2", "1", "3"), newTree.neighbours(2));
        assertEquals(List.of("7", "8", "empty", "empty"), newTree.neighbours(8));
        assertEquals(List.of("empty", "5", "2", "7"), newTree.neighbours(5));

        //проверка перестановки при удалении:
        newTree.delete(2);
        assertEquals(List.of("5", "3", "1", "empty"), newTree.neighbours(3));
        newTree.insert(6);
        newTree.delete(7);
        assertEquals(List.of("5", "8", "6", "empty"), newTree.neighbours(8));
    }

    @Test
    void testFunctions3() {
        BinaryTree newTree = new BinaryTree();
        newTree.insert(22);
        newTree.insert(2);
        newTree.insert(7);
        newTree.insert(1);
        newTree.insert(56);
        newTree.insert(21);
        newTree.insert(22);
        newTree.insert(2);
        newTree.insert(23);
        newTree.insert(9);
        newTree.insert(66);
        newTree.insert(0);
        newTree.insert(111);
        newTree.insert(8);
        newTree.insert(19);
        newTree.insert(16);
        newTree.insert(5);
        newTree.insert(78);
        newTree.insert(20);
        newTree.insert(112);
        newTree.insert(60);
        newTree.insert(54);
        newTree.insert(65);
        newTree.insert(50);
        newTree.insert(55);
        newTree.delete(2);
        assertEquals(List.of("22", "5", "1", "7"), newTree.neighbours(5));
        newTree.delete(56);
        assertEquals(List.of("22", "60", "23", "66"), newTree.neighbours(60));
        newTree.delete(22);
        assertEquals(List.of("empty", "23", "5", "60"), newTree.neighbours(23));
        newTree.delete(21);
     //   assertEquals(List.of("7", "9", "8", "empty"), newTree.neighbours(9));
    }


    @Test
    void testDoubleKey() {     //тест на повторный ввод ключа
        BinaryTree newTree = new BinaryTree();
        newTree.insert(5);
        newTree.insert(5);
        assertEquals(List.of("empty", "5", "empty", "empty"), newTree.neighbours(5));

        newTree.insert(2);
        newTree.insert(7);
        newTree.insert(1);
        newTree.insert(3);
        newTree.insert(8);
        newTree.insert(1);
        newTree.insert(8);
        assertEquals(List.of("2", "1", "empty", "empty"), newTree.neighbours(1));
    }

    @Test
    void testEquals() {
        BinaryTree newTree1 = new BinaryTree();
        BinaryTree newTree2 = new BinaryTree();
        newTree1.insert(2);
        newTree1.insert(7);
        newTree1.insert(1);
        newTree1.insert(3);
        newTree1.insert(8);
        newTree1.insert(1);
        newTree1.insert(8);
        newTree2.insert(2);
        newTree2.insert(7);
        newTree2.insert(1);
        newTree2.insert(3);
        newTree2.insert(8);
        newTree2.insert(1);
        newTree2.insert(8);
        assertEquals(true, newTree1.equals(newTree2));
        newTree1.delete(1);
        assertEquals(false, newTree1.equals(newTree2));
    }
}