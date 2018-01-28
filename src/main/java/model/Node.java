package main.java.model;

import java.util.LinkedList;

public class Node {

    private int value;

    private int inDegree;

    private LinkedList<Node> childList;

    public Node(int value) {
        this.value = value;
        this.inDegree = 0;
        this.childList = new LinkedList<Node>();
    }

    public int getValue() {
        return value;
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public LinkedList<Node> getChildList() {
        return childList;
    }

    public void setChildList(LinkedList<Node> childList) {
        this.childList = childList;
    }


}
