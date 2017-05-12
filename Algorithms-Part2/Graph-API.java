import java.util.*;
import java.io.*;

public class Graph{
    private int V,E;                    //V stores the number of vertices and E stores the number of edges of the graph
    private List<Integer> adjList[];    //The adjacency list for each vertex of the graph

    //Initialise the graph and the adjacency list of each vertex
    public Graph(int V){
        this.V=V;
        adjList = new List[V];
        for(int i=0;i<V;i++){
            adjList[i]=new ArrayList<Integer>();
        }
    }

    public int getV(){
        return V;
    }

    public int getE() {
        return E;
    }

    public addEdge(int v, int w){
        adjList[v].add(w);          //add w to v's list
        adjList[w].add(v);          //add v to w's list
        E++;
    }

    public static void main(String[] args){
        System.out.println("Enter the number of Edges to insert");
        Scanner in = new Scanner(System.in);
        int e = in.nextInt();
        int v,w;
        for (int i = 0;i<e;i++){            //constructing the graph
            v=in.nextInt();
            w=in.nextInt();

            addEdge(v,w);
        }
    }
}