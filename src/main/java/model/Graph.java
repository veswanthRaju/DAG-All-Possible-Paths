package main.java.model;

import java.util.LinkedList;

public class Graph {

    private LinkedList<Tree> rootList;

    public Graph() {
        this.rootList = new LinkedList<Tree>();
    }

    public Graph(LinkedList<Tree> rootList) {
        this.rootList = rootList;
    }

    public LinkedList<Tree> getRootList() {
        return rootList;
    }


}
