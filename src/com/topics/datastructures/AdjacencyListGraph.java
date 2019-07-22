package com.topics.datastructures;

import java.util.*;
import com.topics.datastructures.GraphNode;

/*
Implementation of Graph as Adjacency List
See sample usage in main method below
*/
public class AdjacencyListGraph<T> {
    private Map<GraphNode, Set<GraphNode>> graph;

    public AdjacencyListGraph() {
        graph = new HashMap();
    }

    public Map<GraphNode, Set<GraphNode>> getGraph() {
        return graph;
    }

    public void addEdge(GraphNode from, GraphNode to) {
        Set<GraphNode> edges = graph.computeIfAbsent(from, k -> new HashSet());
        if (to != null) {
            graph.putIfAbsent(to, new HashSet());
            edges.add(to);
        }
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (Map.Entry<GraphNode, Set<GraphNode>> entry: graph.entrySet()) {
            strB.append("Vertex: " + entry.getKey() + " Edges: " + entry.getValue() + "\n");
        }
        return strB.toString();
    }

    public static void main(String[] args) {
        AdjacencyListGraph adjlGraph = new AdjacencyListGraph();
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        adjlGraph.addEdge(nodeA, null);
        adjlGraph.addEdge(nodeB, nodeC);
        adjlGraph.addEdge(nodeB, nodeD);
        System.out.println(adjlGraph);
    }
}
