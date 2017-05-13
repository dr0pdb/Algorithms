/*
* The algorithm to find out number of connected components of a graph using Depth-First search.
*  It can also decide in O(1) time whether two nodes of the graph are connected or not.
*  The key is to maintain a count value and an id array to store the count value at that instant of the search for each node.
*  If for two nodes id value is same then they are connected otherwise they are not.
*  The final count value denotes the number of connected components.
* */

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w);
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}