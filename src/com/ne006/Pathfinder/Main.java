package com.ne006.Pathfinder;

import com.ne006.Pathfinder.Algorithms.Implementations.DijkstraSO;
import com.ne006.Pathfinder.Algorithms.Structures.ALGraph;
import com.ne006.Pathfinder.Algorithms.Structures.Graph;
import com.ne006.Pathfinder.Algorithms.Structures.Node;
import com.ne006.Pathfinder.Algorithms.Structures.Route;

import java.util.AbstractMap;

public class Main {

    public static void main(String[] args) {
        Node s = new Node("S");
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");

        s.addAdjacentNode(a, 1.0).addAdjacentNode(b, 2.0);
        a.addAdjacentNode(c, 5.0);
        b.addAdjacentNode(d, 3.0);
        c.addAdjacentNode(d, 4.0).addAdjacentNode(e, 6.0);
        d.addAdjacentNode(e, 8.0);

        Graph graph = new ALGraph().addNode(s, a, b, c, d, e);

        DijkstraSO alg = new DijkstraSO(graph);
        System.out.println(alg.getRoute(s,e));
    }
}
