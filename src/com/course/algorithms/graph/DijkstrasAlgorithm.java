package com.course.algorithms.graph;

import java.util.*;

public class DijkstrasAlgorithm {

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


    public static Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source){
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>(new Comparator<VertexInfo>() {
            @Override
            public int compare(VertexInfo v1, VertexInfo v2) {
                return Integer.compare(v1.getDistance(), v2.getDistance());
            }
        });
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();

        for (int j = 0; j < graph.getNumberOfVertices(); j++){
            distanceTable.put(j, new DistanceInfo(Integer.MAX_VALUE));
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(source);

        VertexInfo sourceVertexInfo = new VertexInfo(source, 0);
        queue.add(sourceVertexInfo);
        vertexInfoMap.put(source, sourceVertexInfo);


        while(!queue.isEmpty()){
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();

            for(Integer neighbor: graph.getAdjacencyVertices(currentVertex)){
                int distance = distanceTable.get(currentVertex).getDistance() + graph.getWeightedEdge(currentVertex, neighbor);

                if(distanceTable.get(neighbor).getDistance() > distance){
                    distanceTable.get(neighbor).setDistance(distance);
                    distanceTable.get(neighbor).setLastVertex(currentVertex);

                    VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);
                    if(neighborVertexInfo != null) {
                        queue.remove(neighborVertexInfo);
                    }
                    neighborVertexInfo = new VertexInfo(neighbor, distance);
                    queue.add(neighborVertexInfo);
                    vertexInfoMap.put(neighbor, neighborVertexInfo);
                }
            }
        }
        return distanceTable;
    }
}
