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

    @Override
    public boolean equals(Object other) {
        if(this == other) {
            return true;
        }
        if(!(other instanceof Node)) {
            return false;
        }

        Node bst = (Node) other;

        // Check equality of the left child
        if(leftChild != null) {
            if(!leftChild.equals(((Node) other).leftChild)) {
                // Left childs aren't equal
                return false;
            }
        } else if (((Node) other).leftChild != null) {
            // this.left is null but other.left isn't
            return false;
        }

        // Check equality of the right child
        if(rightChild != null) {
            if(!rightChild.equals(((Node) other).rightChild)) {
                // Right childs aren't equal
                return false;
            }
        } else if (((Node) other).rightChild != null) {
            // this.right is null but other.right isn't
            return false;
        }
        // Both left and right childs are equal
        return true;
    }

//    @Override
//    public int hashCode() {
//        ;
//
//    }
}
