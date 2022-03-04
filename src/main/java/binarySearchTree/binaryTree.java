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
    public static void main(String[] args) {
    }
    private Node root;

    public binaryTree() { //Constructor for BST
        root = null;
    }
    public Node find(int key) {
        Node current = root;
        while (current.keyData != key) {
            if (key < current.keyData) {
                current = current.leftChild;
            }
            else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int insertKey, int inserData) {
        Node nextNode = new Node();
        nextNode.keyData = insertKey;
        nextNode.data = inserData;
        if (root == null) {
            root = nextNode;
        }
        else {
            Node current = root;
            while (true) {
                Node parent = current;
                if (insertKey < current.keyData) {
                    parent.leftChild = nextNode;
                    return;
                }
                else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = nextNode;
                        return;
                    }
                }
            }
        }
    }
}