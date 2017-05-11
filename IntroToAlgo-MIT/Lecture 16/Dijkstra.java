/*
* Implementation of the Dijkstra algorithm for graph with adjacency matrix representation
* */

import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPath{

    //No of vertices in the graph
    static final int V=9;

    //To hold the final answer
    static int[] distance= new int[V];
    static boolean[] inSetS = new boolean[V];

    //Setting the initial distances from the source to be infinite and no element is present in the set s.
    public static void initialize(){
        for (int i=0;i<V;i++){
            distance[i]=Integer.MAX_VALUE;
            inSetS[i]=false;
        }
    }

    //To get the element with the minimum distance from the source and not in the set S.
    public static int minDistanceIndex(){
        int min=Integer.MAX_VALUE;
        int minIndex=-1;
        for (int i=0;i<V;i++){
            if (!inSetS[i] && distance[i]<min){
                min=distance[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

    //Function to implement the dijkstra algo for adjacency matrix with source node.
    public static void dijkstra(int graph[][] , int source){
        initialize();
        distance[source]=0;

        for (int count=0;count<V-1;count++){
            int i= minDistanceIndex();
            inSetS[i]=true;
            for (int j=0;j<V;j++){
                if (!inSetS[j] && graph[i][j]!=0 && distance[i]+graph[i][j]<distance[j]){
                    distance[j]=distance[i]+graph[i][j];
                }
            }
        }

        //Printing the final shortest distances
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+distance[i]);
    }



    // Driver method
    public static void main (String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}