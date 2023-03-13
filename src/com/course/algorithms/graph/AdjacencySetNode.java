package com.course.algorithms.graph;

import java.util.*;

public class AdjacencySetNode {
    private int vertexNumber;
    private Set<Integer> adjacencySet = new HashSet<>();

    public AdjacencySetNode(int vertexNumber){
        this.vertexNumber = vertexNumber;
    }

    public int getVertexNumber() {
        return vertexNumber;
    }

    public void addEdge(int vertexNumber){
        this.adjacencySet.add(vertexNumber);
    }

    public List<Integer> getAdjacentVertices() {
        List<Integer> sortedList = new ArrayList<>(adjacencySet);
        Collections.sort(sortedList);

        return sortedList;
    }
}
