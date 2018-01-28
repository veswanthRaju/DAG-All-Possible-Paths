package main.java.service;

import main.java.model.Graph;
import main.java.model.Node;
import main.java.model.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class DAGService {

    public static Node getNodeByValue(LinkedList<Node> inputNodesList, int value) {
        for (int i = 0; i < inputNodesList.size(); i++) {
            Node node = inputNodesList.get(i);
            if (node.getValue() == value)
                return node;
        }
        return null;
    }

    public static void main(String args[]) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the total no of Nodes:");

        String inputTotalNoOfNodes;
        inputTotalNoOfNodes = br.readLine();
        int totalNoOfNodes = -1;
        if (inputTotalNoOfNodes != null) {
            try {
                totalNoOfNodes = Integer.parseInt(inputTotalNoOfNodes);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid input. Please input a valid number");
                return;
            }
        }

        LinkedList<Node> userProvidedinputNodesList = new LinkedList<Node>();
        Graph userProvidedgraph = new Graph();

        for (int i = 0; i < totalNoOfNodes; ++i) {
            Node userProvidedNode = new Node(i);
            userProvidedinputNodesList.add(userProvidedNode);
        }

        System.out.println("Enter total no of edges:");
        String inputNoOfEdges;
        inputNoOfEdges = br.readLine();
        int noOfEdges = -1;
        if (inputNoOfEdges != null) {
            try {
                noOfEdges = Integer.parseInt(inputNoOfEdges);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid input. Please input a valid number");
                return;
            }
        }

        System.out.println("Enter the parent node and child node connected to it:");

        for (int i = 0; i < noOfEdges; ++i) {
            System.out.println("Enter the parent node:");

            int parentNodeValue = -1;
            int childNodeValue = -1;

            String nodeValue = br.readLine();
            if (nodeValue != null) {
                try {
                    parentNodeValue = Integer.parseInt(nodeValue);
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid input. Please input a valid number");
                    return;
                }
            }
            Node parentNode = getNodeByValue(userProvidedinputNodesList, parentNodeValue);

            System.out.println("Enter the connected immediate child node:");
            String userChildNodeValue = br.readLine();
            if (userChildNodeValue != null) {
                try {
                    childNodeValue = Integer.parseInt(userChildNodeValue);
                } catch (NumberFormatException e) {
                    System.out.println("Not a valid input. Please input a valid number");
                    return;
                }
            }
            Node childNode = getNodeByValue(userProvidedinputNodesList, childNodeValue);

            if (childNode != null)
                parentNode.getChildList().add(childNode);
        }

        for (int i = 0; i < userProvidedinputNodesList.size(); ++i) {
            Node currentNode = userProvidedinputNodesList.get(i);
            for (Node n : currentNode.getChildList()) {
                int indegree = n.getInDegree() + 1;
                n.setInDegree(indegree);
            }
        }

        for (int i = 0; i < userProvidedinputNodesList.size(); ++i) {
            Node inputNode = userProvidedinputNodesList.get(i);
            int currentNodeInDegree = inputNode.getInDegree();
            if (currentNodeInDegree == 0)
                userProvidedgraph.getRootList().add(new Tree(inputNode));
        }

        for (Tree tree : userProvidedgraph.getRootList()) {
            tree.printPaths(tree.getRoot());
        }

    }
}
