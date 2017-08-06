package com.ne006.Pathfinder.Algorithms.Structures;

import java.util.Set;

//Abstract class for Graphs
public abstract class Graph {
    public abstract Set<Node> getNodeList();

    public abstract Graph addNode(Node... nodes);

    public abstract Graph removeNode(Node node);

    public abstract Node getNodeByKey(String nodeKey);
}
