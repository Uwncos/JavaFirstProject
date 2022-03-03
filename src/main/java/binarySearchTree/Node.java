package binarySearchTree;

public class Node {
    public int key;
    public Node rightChild;
    public Node leftChild;

    public void nodePrint() {
        System.out.println("Node value:" + key);
    }
    public int getKey() {
        return this.key;
    }
    public Node getLeftChild() {
        return this.leftChild;
    }
    public Node getRightChild() {
        return this.rightChild;
    }
    public void setLeftChild() {
        this.leftChild = leftChild;
    }
    public void setRightChild() {
        this.rightChild = rightChild;
    }
}
