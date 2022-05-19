class Graph:
    def __init__(self, edges, N):
         self.adj = [[] for _ in range(N)]
         for (src, dest) in edges:                # add edges to the undirected graph
            self.adj[src].append(dest)
            self.adj[dest].append(src)

def colorGraph(graph):                            # Function to assign colors to vertices of a graph
    result = {}                                   # keep track of the color assigned to each vertex
    for u in range(N):                            # assign a color to vertex one by one
        assigned = set([result.get(i) for i in graph.adj[u] if i in result])           # check colors of adjacent vertices of `u` and store them in a set
        color = 1                 # check for the first free color
        for c in assigned:
            if color != c:
                break
            color = color + 1
        result[u] = color               # assign vertex `u` the first available color
    for v in range(N):
        print("Color assigned to vertex", v, "is", colors[result[v]])
if __name__ == '__main__':
    colors = ["", "BLUE", "GREEN", "RED", "YELLOW", "ORANGE", "PINK",           
              "BLACK", "BROWN", "WHITE", "PURPLE", "VOILET"]                # Add more colors for graphs with many more vertices

    edges = [(0, 1), (0, 4), (0, 5), (4, 5), (1, 4), (1, 3), (2, 3), (2, 4)]         # List of graph edges 
    N = 6                                                                            # total number of nodes in the graph (labelled from 0 to 5)
    graph = Graph(edges, N)                                                          # build a graph from the given edges
    colorGraph(graph)

#The time complexity of the above solution is O(V × E), where V and E are the total number of vertices and edges in the graph, respectively.