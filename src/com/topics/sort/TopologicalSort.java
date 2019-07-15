package com.topics.sort;

import java.util.*;
import com.topics.datastructures.GraphNode;
import com.topics.datastructures.AdjacencyListGraph;

class TopologicalSort {
    public static void main(String[] args) {
        System.out.println("Topological Sort");
        System.out.println("----------------");
        AdjacencyListGraph graph = createGraph();
        AdjacencyListGraph graphWithCycle = createGraphWithCycle();
        try {
            sortGraph(graph);
            sortGraph(graphWithCycle);
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static AdjacencyListGraph createGraph() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
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
        return graph;
    }

    static AdjacencyListGraph createGraphWithCycle() {
        AdjacencyListGraph graph = new AdjacencyListGraph();
        GraphNode nodeA = new GraphNode("A");
        GraphNode nodeB = new GraphNode("B");
        GraphNode nodeC = new GraphNode("C");
        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeB, nodeC);
        graph.addEdge(nodeC, nodeA);
        System.out.println(graph);
        return graph;
    }

    static void sortGraph(AdjacencyListGraph adjlGraph) {
        Set<GraphNode> visited = new HashSet();
        Deque<GraphNode> stack = new ArrayDeque();
        Map<GraphNode, Set<GraphNode>> graph = adjlGraph.getGraph();
        System.out.print("Output: ");
        for (GraphNode vertex : graph.keySet()) {
            Set<GraphNode> visitedCycleChecker = new HashSet();
            sortGraphHelper(graph, vertex, visited, stack, visitedCycleChecker, 1);
        }
        System.out.println(stack);
    }

    static void sortGraphHelper(Map<GraphNode, Set<GraphNode>> graph, GraphNode vertex,
                            Set<GraphNode> visited, Deque<GraphNode> stack,
                            Set<GraphNode> visitedCycleChecker, int j) {
        // check if graph has cycle by making sure a vertex isn't visited twice
        if (visitedCycleChecker.contains(vertex)) {
            throw new RuntimeException("Graph has a cycle at vertex " + vertex + "!");
        }
        visitedCycleChecker.add(vertex);

        if (!visited.contains(vertex)) {
            visited.add(vertex);
            // traverse all nodes connected to vertex
            for (GraphNode node : graph.get(vertex)) {
                sortGraphHelper(graph, node, visited, stack, visitedCycleChecker, j+1);
            }
            stack.push(vertex);
        }

        // important: remove vertex at the end if no cycle was detected
        visitedCycleChecker.remove(vertex);
    }
}
