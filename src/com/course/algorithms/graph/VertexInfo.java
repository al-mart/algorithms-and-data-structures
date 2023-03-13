package com.course.algorithms.graph;

public class VertexInfo {
    public int getDistance() {
        return distance;
    }

    public int getVertexId() {
        return vertexId;
    }

    private int distance;
    private int vertexId;

    public VertexInfo(int vertexId, int distance){
        this.distance = distance;
        this.vertexId = vertexId;
    }
}
