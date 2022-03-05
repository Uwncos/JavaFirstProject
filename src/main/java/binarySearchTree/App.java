package binarySearchTree;

public class App {
    public static void main(String[] args) {
        BinaryTree newTree = new BinaryTree();
        newTree.insert(7, 90);
        newTree.insert(5, 80);
        newTree.insert(8, 60);
        newTree.insert(7, 90);
        newTree.insert(9, 36);
        newTree.insert(3, 31);
        newTree.insert(4, 20);
        newTree.insert(11, 54);
        newTree.insert(10, 77);

        newTree.delete(11);
    }
}
