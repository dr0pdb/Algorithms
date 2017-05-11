/*
* The Depth-first-search algorithm implemented on a graph
* srv_twry
* */

import java.util.*;
import java.io.*;

public class Graph{

    //Number of vertices
    private static int NV;
    static LinkedList<Integer> adjList[];

    //Constructor for proper initialization
    public Graph(int nv){
        NV=nv;
        adjList = new LinkedList[nv];
        for (int i=0;i<nv;i++){
            adjList[i]= new LinkedList();
        }
    }

    //Function to add an edge to the graph
    public static void addEdge(int vertex, int connected){
        adjList[vertex].add(connected);
    }

    //Helper function for the DFS
    public static void DFS_Helper(int vertex, boolean[] visited){
        visited[vertex]=true;
        System.out.printf("%d\t",vertex);
        Iterator<Integer> itr = adjList[vertex].listIterator();

        //Now iterate through the adjacency list and recursively use DFS-Helper
        while (itr.hasNext()){
            int i=itr.next();
            if (!visited[i]) {
                DFS_Helper(i,visited);
            }
        }
    }

    //The DFS function
    public static void DFS(int vertex){
        boolean[] visited = new boolean[NV];

        for (int i=0;i<NV;i++){
            if ( !visited[i]){
                DFS_Helper(i,visited);
            }
        }
    }

    //Main function
    public static void main(String[] args){
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal "+
                "(starting from vertex 2)");

        g.DFS(2);
    }

}