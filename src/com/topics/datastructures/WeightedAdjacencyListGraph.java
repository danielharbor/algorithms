package com.topics.datastructures;

import java.util.*;

/*
Implementation of a weighted Graph as Adjacency List
See sample usage in main method below
*/
public class WeightedAdjacencyListGraph<T, W extends Comparable<W>> {
    private Map<T, Set<Edge<T, W>>> graph;

    public WeightedAdjacencyListGraph() {
        graph = new HashMap<T, Set<Edge<T, W>>>();
    }

    public void addEdge(T from, T to, W weight) {
        Set<Edge<T, W>> edges = graph.computeIfAbsent(from, k -> new HashSet<Edge<T, W>>());
        if (to != null) {
            graph.putIfAbsent(to, new HashSet<Edge<T, W>>());
            Edge<T, W> edge = new Edge<>(to, weight);
            edges.add(edge);
        }
    }

    public Set<Edge<T, W>> getEdges(T vertex) {
        return graph.get(vertex);
    }

    public W getWeight(T from, T to) {
        for (Edge<T, W> edge : graph.get(from)) {
            if (edge.vertex == to) {
                return edge.weight;
            }
        }
        return null;
    }

    public Set<T> getAllVertices() {
        return graph.keySet();
    }

    public class Edge<V, U extends Comparable<U>> {
        public V vertex;
        public U weight;

        Edge(V vertex, U weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return vertex.toString() + "(" + weight.toString() + ")";
        }
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        for (Map.Entry<T, Set<Edge<T, W>>> entry: graph.entrySet()) {
            strB.append("Vertex: " + entry.getKey() + ", Edges: " + entry.getValue() + "\n");
        }
        return strB.toString();
    }

    public static void main(String[] args) {
        WeightedAdjacencyListGraph<String, Integer> graph = new WeightedAdjacencyListGraph<>();
        graph.addEdge("abc", "def", 2);
        graph.addEdge("abc", "abc", 3);
        graph.addEdge("def", "xyz", 1);
        graph.addEdge("abc", "xyz", 9);
        System.out.println("Entire graph");
        System.out.println("===============");
        System.out.println(graph);
        System.out.println("All vertices: " + graph.getAllVertices());
        System.out.println("Edges for single vertex: " + graph.getEdges("abc"));
    }
}
