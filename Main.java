import java.util.*;

// A class to store a graph edge for DFS
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

// A class to store a graph edge for BFS
class Edge1
{
    int source, dest;
 
    public Edge1(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}

// A class to represent a graph object for DFS
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

// A class to represent a graph object for BFS
class Graph1
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph1(List<Edge1> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge1 edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}

class Main
{
    // Function to perform DFS traversal on the graph
    public static void DFS(Graph graph, int v, boolean[] discovered)
    {
        // mark the current node as discovered
        discovered[v] = true;
 
        // print the current node
        System.out.print(v + " ");
 
        // do for every edge (v, u)
        for (int u: graph.adjList.get(v))
        {
            // if `u` is not yet discovered
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }
    
    // Perform BFS recursively on the graph
    public static void recursiveBFS(Graph1 graph1, Queue<Integer> q,boolean[] discovered)
    {
        if (q.isEmpty()) {
            return;
        }
 
        // dequeue front node and print it
        int v = q.poll();
        System.out.print(v + " ");
 
        // do for every edge (v, u)
        for (int u: graph1.adjList.get(v))
        {
            if (!discovered[u])
            {
                // mark it as discovered and enqueue it
                discovered[u] = true;
                q.add(u);
            }
        }
 
        recursiveBFS(graph1, q, discovered);
    }
    
    public static void main(String[] args)
    {
        // List of graph edges for DFS
		List<Edge> edges = Arrays.asList(
                // Notice that node 0 is unconnected
                new Edge(1, 2), new Edge(1, 7), new Edge(1, 8), new Edge(2, 3),
                new Edge(2, 6), new Edge(3, 4), new Edge(3, 5), new Edge(8, 9),
                new Edge(8, 12), new Edge(9, 10), new Edge(9, 11)
            );
 
        // total number of nodes in the graph (labelled from 0 to 12)
        int n = 13;
		
        // List of graph edges for BFS
        List<Edge1> edges1 = Arrays.asList(
                new Edge1(1, 2), new Edge1(1, 3), new Edge1(1, 4), new Edge1(2, 5),
                new Edge1(2, 6), new Edge1(5, 9), new Edge1(5, 10), new Edge1(4, 7),
                new Edge1(4, 8), new Edge1(7, 11), new Edge1(7, 12)
                // vertex 0, 13, and 14 are single nodes
        );
 
        // total number of nodes in the graph (labelled from 0 to 14)
        int m = 15;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, n);
		Graph1 graph1 = new Graph1(edges1, m);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[n];
		boolean[] discovered1 = new boolean[m];
        
        System.out.println("DFS :");
        for (int i = 0; i < n; i++)
        {
            if (!discovered[i]) {
                DFS(graph, i, discovered);
            }
        }
		
		// create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
        
        System.out.println("\nBFS :");
        for (int i = 0; i < m; i++)
        {
            if (discovered1[i] == false)
            {
                // mark the source vertex as discovered
                discovered1[i] = true;
 
                // enqueue source vertex
                q.add(i);
 
                // start BFS traversal from vertex `i`
                recursiveBFS(graph1, q, discovered);
            }
        }
    }
}
