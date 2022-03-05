package binarySearchTree;

public class Node {
    public int key;
    public int data;
    public Node rightChild;
    public Node leftChild;

    Node(int key, int data) {
        this.key = key;
        this.data = data;
    }

    public void nodePrint() {
        System.out.println("Node value:" + key);
    }
}
