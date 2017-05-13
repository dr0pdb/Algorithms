/*
* Cycle detection in an undirected graph using DFS.
* The aim is to maintain a variable called parent that is the node from which we used dfs.
*  If we come accross a marked node but is not the parent of the current node then the graph has cycle
* */

public class Cycle
{
    private boolean[] marked;
    private boolean hasCycle;
    public Cycle(Graph G)
    {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!marked[s])
                dfs(G, s, s);
    }

    private void dfs(Graph G, int v, int u)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if (!marked[w])
                dfs(G, w, v);
            else if (w != u) hasCycle = true;           //we found a marked vertex but it is not the parent of the current node.
    }
    public boolean hasCycle()
    { return hasCycle; }
}