package binarySearchTree;

/*
Вариант 12 -- бинарное дерево поиска
Хранит целые числа в виде бинарного дерева поиска.
Дерево не может содержать одно и то же число более одного раза.
Методы: добавление числа, удаление числа, поиск числа в дереве,
 определение соседей числа в дереве
 (предок, левый потомок, правый потомок).
 */

public class binaryTree {
    private Node root;

    public binaryTree() { //Constructor for BST
        root = null;
    }
    public Node find(int insertData, int key) {
        Node current = root;
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeftChild();
            }
            else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(Node root, int key) {
        Node nextNode = new Node();
    }
}