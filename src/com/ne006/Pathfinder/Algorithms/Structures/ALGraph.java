package com.ne006.Pathfinder.Algorithms.Structures;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

//Adjacency List Graph
public class ALGraph extends Graph {
    protected Set<Node> nodeList;

    public ALGraph(){
        this.nodeList = new HashSet<Node>();
    }

    @Override
    public Set<Node> getNodeList() {
        return this.nodeList;
    }

    @Override
    public Graph addNode(Node... nodes) {
        for(Node node: nodes) {
            this.getNodeList().add(node);
        }
        return this;
    }

    @Override
    public Graph removeNode(Node node) {
        this.getNodeList().remove(node);
        for(Node otherNode: getNodeList()){
            otherNode.removeAdjacentNode(node);
        }
        return this;
    }

    @Override
    public Node getNodeByKey(String nodeKey) {
        Node node = null;
        for(Node curNode: this.getNodeList()){
            node = curNode;
            if(node.getKey() == nodeKey){
                break;
            }
        }
        return node;
    }
}
