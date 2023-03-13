package com.course.algorithms.graph;

import java.util.List;

public interface Graph {
    enum GraphType {
        DIRECTED,
        UNDIRECTED
    }

    // v1 - source, v2 - destination indexes of vertices
    void addEdge(int v1, int v2);

    List<Integer> getAdjacencyVertices(int v);


    public int getNumberOfVertices();

    public Integer getWeightedEdge(int v1, int v2);

}

