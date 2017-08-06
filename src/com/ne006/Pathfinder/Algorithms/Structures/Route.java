package com.ne006.Pathfinder.Algorithms.Structures;

import java.util.LinkedList;

//Route
public class Route{
    protected LinkedList<Node> nodeSet;
    protected Double metric;

    public Route(){
        this.nodeSet = new LinkedList<Node>();
        this.metric = null;
    }

    public Route(LinkedList<Node> nodeSet){
        this.nodeSet = (LinkedList<Node>) nodeSet.clone();
        this.metric = this.calculateMetric();
    }

    public Route(Node... nodeSet){
        this.nodeSet = new LinkedList<Node>();
        for(Node node: nodeSet){
            this.nodeSet.add(node);
        }
        this.metric = this.calculateMetric();
    }

    public Route(Node node, Double metric){
        this.nodeSet = new LinkedList<Node>();
        this.nodeSet.add(node);
        this.metric = metric;
    }

    public Route clone(){
        return new Route(this.nodeSet);
    }

    public LinkedList<Node> getNodes(){
        return (LinkedList<Node>)this.nodeSet.clone();
    }

    public Route addNode(Node... nodes){
        for(Node node: nodes) {
            this.nodeSet.add(node);
        }
        this.metric = this.calculateMetric();
        return this;
    }

    public Route removeNode(Node node){
        this.nodeSet.remove(node);
        this.metric = this.calculateMetric();
        return this;
    }

    public Node getSourceNode(){
        if(this.getNodes().isEmpty()){
            return null;
        }
        return this.nodeSet.getFirst();
    }

    public Node getDestNode(){
        if(this.getNodes().isEmpty()){
            return null;
        }
        return this.nodeSet.getLast();
    }

    public Double getMetric(){
        return this.metric;
    }

    private Double calculateMetric(){
        if(this.getNodes().isEmpty()){
            return null;
        }

        Double metric = 0.0;
        for(int i=0; i<this.getNodes().size(); i++){
            Node current = this.getNodes().get(i);
            if(i+1<this.getNodes().size()){
                metric += current.metricTo(this.getNodes().get(i+1));
            }
        }
        return metric;
    }

    public String toString(){
        if(this.getMetric() == Double.POSITIVE_INFINITY){
            return String.format("%s with unreachable nodes", this.getNodes());
        }
        return String.format("%s with total cost of %s", this.getNodes(), this.getMetric());
    }
}
