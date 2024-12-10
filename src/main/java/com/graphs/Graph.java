package com.graphs;

public class Graph {

    private int numbVertices;
    private int adjMatrix[][];

    public Graph(int numbVertices){
        this.numbVertices = numbVertices;
        adjMatrix = new int[numbVertices][numbVertices];
    }

    public void addVertex(){
        int[][] newAdMatrix = new int[numbVertices+1][numbVertices+1];
        for(int i=0; i < numbVertices; i++){
            for(int j=0; j < numbVertices; j++){
                newAdMatrix[i][j] = adjMatrix[i][j];
            }
        }
        adjMatrix = newAdMatrix;
        numbVertices++;
    }

    public void removeVertex(int v){
        int[][] newAdjMatrix = new int[numbVertices-1][numbVertices-1];
        for(int i=0; i < numbVertices; i++){
            for(int j=0; j < numbVertices; j++){
                if(i != v || j != v){ // Pranav Task
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }                
            }
        }
        adjMatrix = newAdjMatrix;
        numbVertices--;
    }

    public void addEdge(int i, int j){
        adjMatrix[i][j]=1;
        adjMatrix[j][i]=1;
    }

    public void removeEdge(int i, int j){
        adjMatrix[i][j]=0;
        adjMatrix[j][i]=0;
    }
}
