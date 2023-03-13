package com.course.algorithms.graph;

import com.course.datastructures.stackqueue.CircularQueue;

import java.util.*;

public class AdjacencyMatrix implements Graph {

    private int[][] adjacencyMatrix;
    private GraphType graphType = GraphType.DIRECTED;
    private int numberOfVertices = 0;

    public AdjacencyMatrix(int numberOfVertices, GraphType graphType) {
        this.numberOfVertices = numberOfVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numberOfVertices][numberOfVertices];
        for (int i = 0; i < numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++) {
                adjacencyMatrix[i][j] = 0;
            }
        }
    }

    public void processDepthFirst() {
        // To ensure that all nodes are covered even for unconnected graph
        for (int i = 0; i < numberOfVertices; i++) {
            depthFirstTraversal(this, new int[numberOfVertices], i);
        }
    }

    public void processBreadthFirst() {
        // To ensure that all nodes are covered even for unconnected graph
        for (int i = 0; i < numberOfVertices; i++) {
            breadthFirstTraversal(this, new int[numberOfVertices], i);
        }
    }

    public List<Integer> topologicalSortedList(AdjacencyMatrix graph) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();

        for (int vertex = 0; vertex < graph.getNumberOfVertices(); vertex++){
            int indegree = graph.getIndegree(vertex);
            indegreeMap.put(vertex, indegree);
            if(indegree == 0){
                queue.add(vertex);
            }
        }

        List<Integer> sortedList = new ArrayList<>();

        while(!queue.isEmpty()){
            int vertex = queue.pollLast();
            sortedList.add(vertex);

            List<Integer> adjacentVertices = graph.getAdjacencyVertices(vertex);
            for(int adjacentVertex: adjacentVertices){
                int updatedIndegree = indegreeMap.get(adjacentVertex) - 1;
                indegreeMap.remove(adjacentVertex);
                indegreeMap.put(adjacentVertex, updatedIndegree);
                if(updatedIndegree == 0){
                    queue.add(adjacentVertex);
                }
            }
        }

        if(sortedList.size() != graph.getNumberOfVertices()){
            throw new RuntimeException("The Graph had a cycle!");
        }

        return sortedList;
    }

    public Integer getIndegree(int v){
        if(v < 0 || v >= numberOfVertices) return null;
        int indegree = 0;
        for(int i = 0; i < numberOfVertices; i++){
            if(adjacencyMatrix[i][v] == 1 ){
                indegree++;
            }
        }
        return indegree;
    }

    private void depthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        if (visited[currentVertex] == 1) {
            return;
        }
        visited[currentVertex] = 1;
        List<Integer> list = graph.getAdjacencyVertices(currentVertex);
        for (int v : list) {
            depthFirstTraversal(graph, visited, v);
        }
        System.out.println(currentVertex + "->");
    }

    private void breadthFirstTraversal(Graph graph, int[] visited, int currentVertex) {
        CircularQueue<Integer> queue = new CircularQueue<>(Integer.class);
        queue.enqueue(currentVertex);
        while (!queue.isEmpty()) {
            int vertex = queue.dequeue();
            if (visited[vertex] == 1) {
                continue;
            }
            System.out.println(currentVertex + "->");
            visited[currentVertex] = 1;
            List<Integer> list = graph.getAdjacencyVertices(currentVertex);
            for (int v : list) {
                if (visited[v] != 1) {
                    queue.enqueue(currentVertex);
                }
            }
        }
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (v1 >= numberOfVertices || v1 < 0 || v2 >= numberOfVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        adjacencyMatrix[v1][v2] = 1;
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacencyVertices(int v) {
        if (v >= numberOfVertices || v < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        List<Integer> adjacencyVerticesList = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            if (adjacencyMatrix[v][i] == 1) {
                adjacencyVerticesList.add(i);
            }
        }

        Collections.sort(adjacencyVerticesList);
        return adjacencyVerticesList;
    }

    @Override
    public Integer getWeightedEdge(int v1, int v2) {
        if (v1 >= numberOfVertices || v1 < 0 || v2 >= numberOfVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        return adjacencyMatrix[v1][v2];
    }
}
