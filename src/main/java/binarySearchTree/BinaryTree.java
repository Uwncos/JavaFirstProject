package binarySearchTree;

import java.util.*;

/*
Вариант 12 -- бинарное дерево поиска
Хранит целые числа в виде бинарного дерева поиска.
Дерево не может содержать одно и то же число более одного раза.
Методы: добавление числа, удаление числа, поиск числа в дереве,
 определение соседей числа в дереве
 (предок, левый потомок, правый потомок).
 */

public class BinaryTree {

    Node root;
    LinkedList<Integer> nodes = new LinkedList<>();

    public BinaryTree() { //Constructor for BST
        root = null;
    }

    public Node find(int key) {
        Node current = root;

        while (current.key != key) {
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public LinkedList<Integer> neighbours(int key) {
        Node current = root;
        Node parent = null;

        while (current.key != key) {
            parent = current;
            if (key < current.key) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        LinkedList<Integer> nodeNeighbours = new LinkedList<>();

        if (parent != null) {
            nodeNeighbours.add(parent.key);  //если есть ставим key
        }
        else {
            nodeNeighbours.add(0);           //если нет, ставим 0
        }

        nodeNeighbours.add(current.key);

        if (current.leftChild != null) {
            nodeNeighbours.add(current.leftChild.key);
        }
        else {
            nodeNeighbours.add(0);
        }
        if (current.rightChild != null) {
            nodeNeighbours.add(current.rightChild.key);
        }
        else {
            nodeNeighbours.add(0);
        }
        return nodeNeighbours;
    }



    public void insert(int key) {
        Node nextNode = new Node(key);
        if (!nodes.contains(key)) {
            nodes.add(key);
        }
        else {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException exception) {
                return;
            }
        }

        if (root == null) {
            root = nextNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (key < current.key) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = nextNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = nextNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;

        boolean isLeft = true;
        while (current.key != key) {      //search
            parent = current;

            if (key < current.key) {
                isLeft = true;
                current = current.leftChild;
            } else {
                isLeft = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.rightChild == null && current.leftChild == null) { //Node Is A Leaf Node
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeft) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeft) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else {      //two child
            Node toMove = getMove(current);
            if (current == root) {
                root = toMove;
            } else if (isLeft) {
                parent.leftChild = toMove;
            } else {
                parent.rightChild = toMove;
            }
            toMove.leftChild = current.leftChild;
        }
        nodes.remove((Integer) key);
        return true;
    }

    public Node getMove(Node movedNode) {
        Node moveParent = movedNode;
        Node toMove = movedNode;
        Node current = movedNode.rightChild;

        while (current != null) {
            moveParent = toMove;
            toMove = current;
            current = current.leftChild;
        }
        if (toMove != movedNode.rightChild) {
            moveParent.leftChild = toMove.rightChild;
            toMove.rightChild = movedNode.rightChild;
        }
        return toMove;
    }

}




















