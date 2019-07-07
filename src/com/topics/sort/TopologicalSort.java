package com.topics.sort;

import java.util.*;
import com.topics.datastructures.GraphNode;
import com.topics.datastructures.AdjacencyListGraph;

class TopologicalSort {
    public static void main(String[] args) {
        System.out.println("Topological Sort");
        AdjacencyListGraph graph = new AdjacencyListGraph();
        populateGraph(graph);
        sortGraph(graph);
    }

    static void populateGraph(AdjacencyListGraph graph) {
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        GraphNode nodeD = new GraphNode("D");
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeC, nodeB);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeC, nodeD);
        graph.addEdge(nodeA, nodeC);
        System.out.println(graph);
    }

    static void sortGraph(AdjacencyListGraph adjlGraph) {
        Set<GraphNode> visited = new HashSet();
        Deque<GraphNode> stack = new ArrayDeque();
        Map<GraphNode, Set<GraphNode>> graph = adjlGraph.getGraph();
        for (GraphNode vertex : graph.keySet()) {
            sortGraphHelper(graph, vertex, visited, stack);
        }
        System.out.println(stack);
    }

    static void sortGraphHelper(Map<GraphNode, Set<GraphNode>> graph, GraphNode vertex,
                            Set<GraphNode> visited, Deque<GraphNode> stack) {
        if (!visited.contains(vertex)) {
            visited.add(vertex);
            // traverse all nodes connected to vertex
            System.out.println(vertex);
            for (GraphNode node : graph.get(vertex)) {
                sortGraphHelper(graph, node, visited, stack);
            }
            stack.push(vertex);
        }
    }
}
