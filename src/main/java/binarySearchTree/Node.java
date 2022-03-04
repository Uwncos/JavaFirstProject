package binarySearchTree;

public class Node {
    public int keyData;
    public int data;
    public Node rightChild;
    public Node leftChild;

    public void nodePrint() {
        System.out.println("Node value:" + keyData);
    }
    public int getKey() {
        return this.keyData;
    }
    public Node getLeftChild() {
        return this.leftChild;
    }
    public Node getRightChild() {             //геттер
        return this.rightChild;
    }
    public void setLeftChild() {
        this.leftChild = leftChild;
    }
    public void setRightChild() {             //сеттер
        this.rightChild = rightChild;
    }
}
