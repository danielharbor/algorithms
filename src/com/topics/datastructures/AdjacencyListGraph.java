package com.topics.datastructures;

import java.util.*;

/*
Implementation of Graph as Adjacency List
See sample usage in main method below
*/
public class AdjacencyListGraph<T> {
    private Map<T, Set<T>> graph;

    public AdjacencyListGraph() {
        graph = new HashMap<T, Set<T>>();
    }

    public Map<T, Set<T>> getGraph() {
        return graph;
    }

    public void addEdge(T from, T to) {
        Set<T> edges = graph.computeIfAbsent(from, k -> new HashSet<T>());
        if (to != null) {
            graph.putIfAbsent(to, new HashSet<T>());
            edges.add(to);
        }
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (Map.Entry<T, Set<T>> entry: graph.entrySet()) {
            strB.append("Vertex: " + entry.getKey() + " Edges: " + entry.getValue() + "\n");
        }
        return strB.toString();
    }

    public static void main(String[] args) {
        AdjacencyListGraph<Wrapper<Integer>> graph1 = new AdjacencyListGraph<>();

        Wrapper<Integer> nodeA = new Wrapper<>(1);
        Wrapper<Integer> nodeB = new Wrapper<>(2);
        Wrapper<Integer> nodeC = new Wrapper<>(3);
        Wrapper<Integer> nodeD = new Wrapper<>(4);
        graph1.addEdge(nodeA, null);
        graph1.addEdge(nodeB, nodeC);
        graph1.addEdge(nodeB, nodeD);

        System.out.println("Wrapper Map");
        System.out.println("=======================");

        System.out.println(graph1);

        AdjacencyListGraph<String> graph2 = new AdjacencyListGraph<>();
        graph2.addEdge("abc", "def");
        graph2.addEdge("abc", "abc");
        graph2.addEdge("def", "xyz");
        graph2.addEdge("abc", "xyz");

        System.out.println("String Map");
        System.out.println("=======================");

        System.out.println(graph2);
    }
}
