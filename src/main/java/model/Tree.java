package main.java.model;

public class Tree {

    Node root;
    private static final int maxSize = 1000;

    public Tree(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public void printPaths(Node node) {
        int path[] = new int[maxSize];
        printPathsUtils(node, path, 0);
    }

    public boolean isLeafNode(Node node) {
        if (node.getChildList().size() == 0)
            return true;
        return false;
    }

    public void printRootToLeafPath(int path[], int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(path[i]);
            if (i != length - 1)
                System.out.print("->");
        }
        System.out.println("");
    }

    public void printPathsUtils(Node node, int path[], int length) {

        if (node == null)
            return;

        path[length] = node.getValue();
        length++;

        if (isLeafNode(node))
            printRootToLeafPath(path, length);
        else {
            int size = node.getChildList().size();
            for (int i = 0; i < size; ++i) {
                printPathsUtils(node.getChildList().get(i), path, length);
            }
        }

    }
}
