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
    private Node root;


    public BinaryTree() { //Constructor for BST
        root = null;
    }

    Node find(int key) {
        Node current = root;
        while (current.getKey() != key) {
            if (key < current.getKey()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    List<String> neighbours(int key) {
        Node current;
        Node parent;

        current = find(key);
        if (current == null) {
            return null;
        }
        parent = current.getParent();

        LinkedList<String> nodeNeighbours = new LinkedList<>();

        if (parent != null) {
            nodeNeighbours.add("" + parent.getKey());  //если есть ставим key
        } else {
            nodeNeighbours.add("empty");
        }

        nodeNeighbours.add("" + current.getKey());

        if (current.getLeftChild() != null) {
            nodeNeighbours.add("" + current.getLeftChild().getKey());
        } else {
            nodeNeighbours.add("empty");
        }
        if (current.getRightChild() != null) {
            nodeNeighbours.add("" + current.getRightChild().getKey());
        } else {
            nodeNeighbours.add("empty");
        }
        return nodeNeighbours;
    }


    void insert(int key) {
        Node nextNode = new Node();
        nextNode.setKey(key);

        if (root == null) {
            root = nextNode;
            nextNode.setParent(null);          //fixes
        } else {
            Node current = root;
            Node parent;
            if (find(key) != null) {
                return;
            }
            while (true) {
                nextNode.setParent(current);
                if (key < current.getKey()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        nextNode.getParent().setLeftChild(nextNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        nextNode.getParent().setRightChild(nextNode);
                        return;
                    }
                }
            }
        }
    }

    boolean delete(int key) {
        Node current = find(key);
//        Node current = root;
        Node parent = root;

        boolean isLeft = true;

        if (current == null) {
            return false;
        }

        parent = current.getParent();

        isLeft = current.isLeftChild();

        if (current.getRightChild() == null && current.getLeftChild() == null) { //Node Is A Leaf
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.setLeftChild(null);

            } else {
                parent.setRightChild(null);
            }

        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
                current.getLeftChild().setParent(null);
            } else if (isLeft) {
                parent.setLeftChild(current.getLeftChild());
                current.getLeftChild().setParent(parent);
            } else {
                parent.setRightChild(current.getLeftChild());
                current.getLeftChild().setParent(parent);
            }

        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
                current.getRightChild().setParent(parent);
            } else if (isLeft) {
                parent.setLeftChild(current.getRightChild());
                current.getRightChild().setParent(parent);
            } else {
                parent.setRightChild(current.getRightChild());
                current.getRightChild().setParent(parent);
            }

        } else {      //two child
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeft) {
                parent.setLeftChild(successor);

            } else {
                parent.setRightChild(successor);
            }
            successor.setParent(current.getParent());
            successor.setLeftChild(current.getLeftChild());
            current.getLeftChild().setParent(successor);
        }
        return true;
    }

    // достает след. значение после входного
    //идет сначала 1 раз направо, затем налево от всех узлов
    //так мы максимально приблизимся к удаляемому справа
    Node getSuccessor(Node heir) {
        Node successorParent = heir;
        Node successor = heir;
        Node current = heir.getRightChild();

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeftChild();
        }
        if (successor != heir.getRightChild()) {
            successorParent.setLeftChild(successor.getRightChild());
            successor.setRightChild(heir.getRightChild());
        }
        return successor;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (this.getClass() != object.getClass() || object == null) {
            return false;
        }
        BinaryTree other = (BinaryTree) object;
        List<Integer> array1 = treeToList(this.root);
        List<Integer> array2 = treeToList(other.root);
        return array1.equals(array2);
    }

    static List<Integer> treeToList(Node n) {

        List<Integer> result = new ArrayList<>();
        if (n.getLeftChild() != null) {
            result.addAll(treeToList(n.getLeftChild()));
        }
        if (n.getRightChild() != null) {
            result.addAll(treeToList(n.getRightChild()));
        }
        result.add(n.getKey());

        return result;
    }

    @Override
    public int hashCode() {
        int h = treeToList(this.root).hashCode();
        return h;
    }
}




















