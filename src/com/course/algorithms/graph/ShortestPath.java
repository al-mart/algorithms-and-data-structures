package com.course.algorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class ShortestPath {


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
        for (int j = 0; j < graph.getNumberOfVertices(); j++) {
            distanceTable.put(j, new DistanceInfo(-1));
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(0);

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){
            int currentVertex = queue.pollFirst();
            for(int i : graph.getAdjacencyVertices(currentVertex)){
                DistanceInfo currentRow = distanceTable.get(i);
                int currentDistance = currentRow.getDistance();
                if(currentDistance == -1 ){
                    currentDistance = 1 + distanceTable.get(currentVertex).getDistance();
                    currentRow.setDistance(currentDistance);
                    currentRow.setLastVertex(currentVertex);
                    if(!graph.getAdjacencyVertices(i).isEmpty()){
                        queue.add(i);
                    }
                }
             }
        }
        return distanceTable;
    }
}
