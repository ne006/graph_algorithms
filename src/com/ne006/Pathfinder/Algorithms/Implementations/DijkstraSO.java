package com.ne006.Pathfinder.Algorithms.Implementations;

import com.ne006.Pathfinder.Algorithms.Structures.Graph;
import com.ne006.Pathfinder.Algorithms.Structures.Node;
import com.ne006.Pathfinder.Algorithms.Structures.Route;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

//Implementation of Dijkstra's Algorithm
public class DijkstraSO {
    protected Graph graph;

    public DijkstraSO(Graph graph){
        this.graph = graph;
    }

    public Route getRoute(Node source, Node dest){
        return this.calcSPFTree(source).get(dest);
    }

    public HashMap<Node, Route> calcSPFTree(Node source){
        PriorityQueue<Route> current = this.initRoutes(source);
        HashMap<Node, Route> visited = new HashMap<Node, Route>();

        while(current.isEmpty() == false){
            Route minRoute = current.peek();
            visited.put(minRoute.getDestNode(), minRoute);

            for(Node node : minRoute.getDestNode().getAdjacentNodes()){
                if(visited.containsKey(node)){
                    continue;
                }

                Route newRoute = minRoute.clone().addNode(node);
                for(Route route : current){
                    if(route.getDestNode() == node && route.getMetric() > newRoute.getMetric()){
                        current.remove(route);
                        current.add(newRoute);
                        break;
                    }
                }
            }
            current.remove(minRoute);
        }

        return visited;
    }

    private PriorityQueue<Route> initRoutes(Node source){
        PriorityQueue<Route> routes = new PriorityQueue<Route>((x, y) -> (int)(x.getMetric() - y.getMetric()));
        for(Node node : this.graph.getNodeList()){
            if(node == source){
                routes.add(new Route(node));
            } else {
                routes.add(new Route(node, Double.POSITIVE_INFINITY));
            }
        }
        return routes;
    }
}
