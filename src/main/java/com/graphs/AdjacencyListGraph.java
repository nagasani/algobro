package com.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyListGraph {

    private Map<Integer, List<Integer>> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int source, int destination){
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public void removeEdge(int source, int destination){
        adjacencyList.get(source).remove((Integer)destination);
        adjacencyList.get(destination).remove((Integer)source);
    }

    public void addVertex(int vertex){
        adjacencyList.put(vertex, new ArrayList<>());
    }

    
    public void removeVertex(int vertex){
        adjacencyList.remove(vertex);
        for(List<Integer> neighbors: adjacencyList.values()){
            neighbors.remove((Integer)vertex);
        }
    }
    
    public void removeVertexP(int vertex){
        List<Integer> list = adjacencyList.get(vertex);        
        for(Integer neighbor : list){
            //adjacencyList.get(neighbors).remove((Integer)vertex);
            removeEdge(vertex, neighbor);            
        }
    }
}
