/*
* The General API used for the Directed unweighted graph.
* Even for the weighted graph we can replace the list of tail node with pair of tail node and weight
* */

public class Digraph
{
    private final int V;
    private int E;
    private List<Integer>[] adj;

    public Digraph(int V)
    {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for (int v = 0; v < V; v++)
            adj[v] = new List<Integer>();
    }
    public int V(){
        return V;

    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v)
    { return adj[v]; }

    public Digraph reverse()
    {
        Digraph R = new Digraph(V);
        for (int v = 0; v < V; v++)
            for (int w : adj(v))
                R.addEdge(w, v);
        return R;
    }
}