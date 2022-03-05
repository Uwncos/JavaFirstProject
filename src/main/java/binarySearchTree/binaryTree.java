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

    Node root;

    public binaryTree() { //Constructor for BST
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

    public void insert(int key, int data) {
        Node nextNode = new Node(key, data);
        //nextNode.key = key;
        //nextNode.data = data;
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
                        parent.rightChild = nextNode;
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
        while (current.key != key) {
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
            } else if (isLeft == true) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeft == true) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeft == true) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        else {
            Node toMove = getMove(current);
            if (current == root) {
                root = toMove;
            }
            else if (isLeft == true) {
                parent.leftChild = toMove;
            }
            else {
                parent.rightChild = toMove;
            }
            toMove.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getMove(Node movedNode) {
        Node moveParent = movedNode;
        Node toMove = movedNode;
        Node current = movedNode.rightChild;

        while (current != null){
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




















