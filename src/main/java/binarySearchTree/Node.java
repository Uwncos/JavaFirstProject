package binarySearchTree;


import java.util.TreeSet;

class Node {
    private int key;
    private Node rightChild;
    private Node leftChild;
    private Node parent;


    public int getKey() {
        return this.key;
    }
    public void setKey(final int key) {
        this.key = key;
    }
    public Node getRightChild() {
        return this.rightChild;
    }
    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }
    public Node getLeftChild() {
        return this.leftChild;
    }
    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }
    public void setParent(final Node parent) {
        this.parent = parent;
    }
    public Node getParent() {
        return this.parent;
    }
    public boolean isLeftChild() {
        return getParent() != null && this == getParent().getLeftChild();
    }
    public boolean isRightChild() {
        return getParent() != null && this == getParent().getRightChild();
    }

}
