package com.topics.graph;

import com.topics.datastructures.WeightedAdjacencyListGraph;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

/*
 Implementation of Dijkstra's algorithm
 Based on https://www.youtube.com/watch?v=pVfj6mxhdMw
*/
public class Dijkstras {
    static WeightedAdjacencyListGraph<String, Integer> graph;
    static Set<String> unvisited;

    public static void main(String... args) {
        System.out.println("Graph");
        System.out.println("====================");
        graph = new WeightedAdjacencyListGraph<>();
        graph.addEdge("A", "B", 6);
        graph.addEdge("B", "A", 6);
        graph.addEdge("A", "D", 1);
        graph.addEdge("D", "A", 1);
        graph.addEdge("D", "B", 2);
        graph.addEdge("B", "D", 2);
        graph.addEdge("D", "E", 1);
        graph.addEdge("E", "D", 1);
        graph.addEdge("B", "E", 2);
        graph.addEdge("E", "B", 2);
        graph.addEdge("B", "C", 5);
        graph.addEdge("C", "B", 5);
        graph.addEdge("C", "E", 5);
        graph.addEdge("E", "C", 5);
        System.out.println(graph);
        System.out.println("Shortest Path Info");
        System.out.println("====================");
        System.out.println(findShortestPath("A"));
    }

    static class DijkstraInfo {
        public int distance;
        public String previousVertex;
        DijkstraInfo(int distance, String previous) {
            this.distance = distance;
            this.previousVertex = previous;
        }

        @Override
        public String toString() {
            return "SPath: " + distance + " PrevVertex: " + previousVertex + "\n";
        }
    }

    static Map<String, DijkstraInfo> findShortestPath(String start) {
        unvisited = graph.getAllVertices();

        // initialize result
        Map<String, DijkstraInfo> map = new HashMap<>();
        for (String edge : graph.getAllVertices()) {
            if (edge == start) {
                // distance from start to itself is 0
                map.put(start, new DijkstraInfo(0, null));
            } else {
                // distance from start to all other nodes is unknown, so set to "infinity"
                map.put(edge, new DijkstraInfo(Integer.MAX_VALUE, null));
            }
        }

        while (!unvisited.isEmpty()) {
            // find the unvisited vertex with the smallest known distance from the start vertex
            // the first time around, this is the start vertex, with distance 0
            String curVertex = findSmallestUnvisitedVertex(map);
            updateUnvisitedNeighbors(map, curVertex);
            unvisited.remove(curVertex);
        }

        return map;
    }

    static String findSmallestUnvisitedVertex(Map<String, DijkstraInfo> map) {
        int min = Integer.MAX_VALUE;
        String smallest = "";
        for (String vertex : unvisited) {
            DijkstraInfo info = map.get(vertex);
            if (info.distance < min) {
                smallest = vertex;
            }
        }
        return smallest;
    }

    static void updateUnvisitedNeighbors(Map<String, DijkstraInfo> map, String vertex) {
        for (WeightedAdjacencyListGraph<String, Integer>.Edge<String, Integer> edge : graph.getEdges(vertex)) {
            if (unvisited.contains(edge.vertex)) {
                DijkstraInfo startInfo = map.get(vertex);
                DijkstraInfo edgeInfo = map.get(edge.vertex);
                int curDistance = startInfo.distance + graph.getWeight(vertex, edge.vertex);
                if (curDistance < edgeInfo.distance) {
                    map.put(edge.vertex, new DijkstraInfo(curDistance, vertex));
                }
            }
        }
    }
}
