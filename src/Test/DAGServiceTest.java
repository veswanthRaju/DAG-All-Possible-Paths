package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import main.java.model.Node;
import main.java.model.Graph;
import main.java.model.Tree;

public class DAGServiceTest {

    private static Node node0 = new Node(0);
    private static Node node1 = new Node(1);
    private static Node node2 = new Node(2);
    private static Node node3 = new Node(3);
    private static Node node4 = new Node(4);
    private static Node node5 = new Node(5);
    private static Node node6 = new Node(6);

    private static LinkedList<Node> inputNodesList = new LinkedList<Node>();
    private static Graph graph = new Graph();


    public static void initializeNodes() {

        node0.getChildList().add(node1);
        node0.getChildList().add(node2);
        node1.getChildList().add(node3);
        node1.getChildList().add(node5);
        node2.getChildList().add(node5);
        node6.getChildList().add(node2);

    }

    public static void initializeInputNodesList() {
        inputNodesList.add(node0);
        inputNodesList.add(node1);
        inputNodesList.add(node2);
        inputNodesList.add(node3);
        inputNodesList.add(node4);
        inputNodesList.add(node5);
        inputNodesList.add(node6);
    }

    public static void updateIndegree() {

        for (int i = 0; i < inputNodesList.size(); ++i) {
            Node currentNode = inputNodesList.get(i);
            for (Node n : currentNode.getChildList()) {
                int indegree = n.getInDegree() + 1;
                n.setInDegree(indegree);
            }
        }
    }

    public static void initializeGraph() {

        for (int i = 0; i < inputNodesList.size(); ++i) {
            Node inputNode = inputNodesList.get(i);
            int currentNodeInDegree = inputNode.getInDegree();
            if (currentNodeInDegree == 0)
                graph.getRootList().add(new Tree(inputNode));
        }

    }


    public static void main(String args[]) throws IOException {

        initializeNodes();

        initializeInputNodesList();

        updateIndegree();

        initializeGraph();

        assert (graph.getRootList().size() == 4);
        for (Tree tree : graph.getRootList()) {
            tree.printPaths(tree.getRoot());
        }

    }
}
