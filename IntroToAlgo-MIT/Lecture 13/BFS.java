import java.util.*;
import java.io.*;

public class BFS{

    private static Queue<Integer> queue;

    public BFS(){
        queue = new LinkedList<Integer>();
    }

    //To do Breadth first search of the graph
    public static void BreadthFirstSearch(int[][] ajc_matrix , int source){
        int number_nodes = ajc_matrix[0].length-1;

        boolean[] visited = new boolean[number_nodes];

        int i, element;
        visited[source]=true;

        queue.add(source);
        while (!queue.isEmpty()){
            element = queue.remove();
            i=element;
            System.out.printf("%d\t",i);
            while (i<=number_nodes){
                if (ajc_matrix[element][i]==1 && !visited[i]){
                    queue.add(i);
                    visited[i]=true;
                }
                i++;
            }
        }
    }

    //Main function
    public static void main(String[] args){
        int number_no_nodes, source;
        Scanner scanner = null;

        try
        {
            System.out.println("Enter the number of nodes in the graph");
            scanner = new Scanner(System.in);
            number_no_nodes = scanner.nextInt();

            int adjacency_matrix[][] = new int[number_no_nodes + 1][number_no_nodes + 1];
            System.out.println("Enter the adjacency matrix");
            for (int i = 1; i <= number_no_nodes; i++)
                for (int j = 1; j <= number_no_nodes; j++)
                    adjacency_matrix[i][j] = scanner.nextInt();

            System.out.println("Enter the source for the graph");
            source = scanner.nextInt();

            System.out.println("The BFS traversal of the graph is ");
            BFS bfs = new BFS();
            bfs.BreadthFirstSearch(adjacency_matrix, source);

        } catch (InputMismatchException inputMismatch)
        {
            System.out.println("Wrong Input Format");
        }
        scanner.close();
    }
}