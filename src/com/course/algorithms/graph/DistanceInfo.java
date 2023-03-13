package com.course.algorithms.graph;

public class DistanceInfo {
    private int distance;
    private int lastVertex;

    public DistanceInfo(int distance){
        this.distance = distance;
        lastVertex = -1;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }
}
