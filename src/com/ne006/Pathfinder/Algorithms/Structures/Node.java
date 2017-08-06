package com.ne006.Pathfinder.Algorithms.Structures;

import java.util.HashMap;
import java.util.Set;

//A node in a Graph
//Used for adjacency list representation of a graph
public class Node {
    private String key;
    private HashMap<Node, Double> neighbors;

    public Node(String key, HashMap<Node, Double> neighbors){
        this.key = key;
        this.neighbors = neighbors;
    }

    public Node(String key){
        this.key = key;
        this.neighbors = new HashMap<Node, Double>();
    }

    public String getKey(){
        return this.key;
    }

    public void setKey(String key){
        this.key = key;
    }

    public Set<Node> getAdjacentNodes(){
        return this.neighbors.keySet();
    }

    public String toString(){
        return this.key;
    }

    public Node addAdjacentNode(Node node, Double metric){
        this.addNode(node, metric);
        node.addNode(this, metric);
        return this;
    }

    public Node removeAdjacentNode(Node node){
        this.removeNode(node);
        node.removeNode(this);
        return this;
    }

    public boolean adjacentTo(Node node){
        return this.neighbors.containsKey(node);
    }

    public double metricTo(Node node){
        if(this.neighbors.containsKey(node)) {
            return this.neighbors.get(node);
        } else {
            return Double.POSITIVE_INFINITY;
        }
    }

    protected Node addNode(Node node, Double metric){
        this.neighbors.put(node, metric);
        return this;
    }

    protected Node removeNode(Node node){
        this.neighbors.remove(node);
        return this;
    }
}
