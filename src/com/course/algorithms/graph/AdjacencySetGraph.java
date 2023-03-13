package com.course.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencySetGraph implements Graph{

    private List<AdjacencySetNode> vertexList = new ArrayList<>();
    private GraphType graphType = GraphType.DIRECTED;
    int numberOfVertices = 0;

    public AdjacencySetGraph(int numberOfVertices, GraphType graphType){
        this.numberOfVertices = numberOfVertices;
        for(int i = 0; i < numberOfVertices; i++){
            vertexList.add(new AdjacencySetNode(i));
        }
        this.graphType = graphType;
    }


    @Override
    public void addEdge(int v1, int v2) {
        if(v1 >= numberOfVertices || v1 < 0 || v2 >= numberOfVertices || v2 < 0) {
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        vertexList.get(v1).addEdge(v2);
        if(graphType == GraphType.UNDIRECTED){
            vertexList.get(v2).addEdge(v1);
        }
    }

    @Override
    public List<Integer> getAdjacencyVertices(int v) {
        if( v >= numberOfVertices || v < 0 ){
            throw new IllegalArgumentException("Vertex number is not valid");
        }
        return vertexList.get(v).getAdjacentVertices();
    }

    @Override
    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    @Override
    public Integer getWeightedEdge(int v1, int v2) {
        return null;
    }
}
