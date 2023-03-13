package com.course.algorithms.graph;

import java.util.*;

public class BellmanFordAlgorithm {


    public static void shortestPath(Graph graph,int source, int destination){
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);

        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source){
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }

        if(previousVertex == -1){
            System.out.println("There is no path from node " + source + "to node " + destination);
        } else {
            System.out.println("Shortest path is " + source);
            while (!stack.isEmpty()){
                System.out.println("  - >  " + stack.pop());
            }
            System.out.println("Shortest path unweighted done");
        }
    }

    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();

        for (int j = 0; j < graph.getNumberOfVertices(); j++) {
            // Setting Infinity can cause overflow as we add negative values.
            distanceTable.put(j, new DistanceInfo(10000));
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);
        LinkedList<Integer> queue = new LinkedList<>();

        for (int numberOfIterations = 0; numberOfIterations < graph.getNumberOfVertices() - 1; numberOfIterations++) {
            for (int v = 0; v < graph.getNumberOfVertices(); v++) {
                queue.add(v);
            }

            Set<String> visitedEdges = new HashSet<>();
            while (!queue.isEmpty()) {
                int currentVertex = queue.pollFirst();
                for (Integer neighbor : graph.getAdjacencyVertices(currentVertex)) {
                    String edge = String.valueOf(currentVertex) + String.valueOf(neighbor);

                    if (visitedEdges.contains(edge)) {
                        continue;
                    }
                    visitedEdges.add(edge);

                    int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbor);

                    if (distanceTable.get(neighbor).getDistance() > distance) {
                        distanceTable.get(neighbor).setDistance(distance);
                        distanceTable.get(neighbor).setLastVertex(currentVertex);
                    }
                }
            }
        }

        for (int v = 0; v < graph.getNumberOfVertices(); v++) {
            queue.add(v);
        }
        while (!queue.isEmpty()) {
            int currentVertex = queue.pollFirst();
            for (Integer neighbor : graph.getAdjacencyVertices(currentVertex)) {
                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbor);

                if (distanceTable.get(neighbor).getDistance() > distance) {
                    throw new IllegalArgumentException("The Graph has a -ve cycle");
                }
            }
        }
        return distanceTable;
    }
}
