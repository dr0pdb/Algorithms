public class DepthFirstSearch
{
	private boolean[] marked;
	private int count;
	public DepthFirstSearch(Graph G, int s)
	{
		marked = new boolean[G.V()];		//G.V()-returns the number of vertices in the graph
		dfs(G, s);
	}
	private void dfs(Graph G, int v)
	{
		marked[v] = true;
		count++;
		for (int w : G.adj[v])			//G.adj[v] is the adjacency list of the vertex v of the graph G
			if (!marked[w]) dfs(G, w);
	}
	public boolean marked(int w)
		{ return marked[w]; }
	public int count()
		{ return count; }
}
