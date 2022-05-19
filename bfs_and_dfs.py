from collections import defaultdict
from collections import deque


class GraphDFS:
    def __init__(self):
        self.graph = defaultdict(list)

    def addEdge(self, u, v):
        self.graph[u].append(v)

    def DFSTraverse(self, v, visited):
        visited.add(v)
        print(v, end=' ')

        for neighbour in self.graph[v]:
            if neighbour not in visited:
                self.DFSTraverse(neighbour, visited)

    def DFS(self, v):
        visited = set()
        self.DFSTraverse(v, visited)


class GraphBFS:
    def __init__(self, edges, n):
        self.adjList = [[] for _ in range(n)]
        for (src, dest) in edges:
            self.adjList[src].append(dest)
            self.adjList[dest].append(src)


def recursiveBFS(graph, q, discovered):
    if not q:
        return
    v = q.popleft()
    print(v, end=' ')

    for u in graph.adjList[v]:
        if not discovered[u]:
            discovered[u] = True
            q.append(u)

    recursiveBFS(graph, q, discovered)


if __name__ == "__main__":
    while True:
        print("********** MENU **********")
        print("1. DFS\n2. BFS\n3. Exit")
        choice = int(input("Enter Your Choise: "))

        if choice == 1:
            # DFS
            g_dfs = GraphDFS()

            n = int(input("Enter Number of Edges:-> "))
            for i in range(n):
                print("Edge ", i+1, ":->")
                a, b = map(int, input().split())

                g_dfs.addEdge(a, b)
            print("Enter the Starting Vertex :-> ")
            start = int(input())

            print("DFS : ")
            g_dfs.DFS(start)
        elif choice == 2:
            # BFS
            edges = []

            n = int(input("Enter number of nodes:"))
            n_edge = int(input("Enter number of Edges:"))
            for i in range(n_edge):
                print("Edge ", i+1, ":-> ")
                a, b = map(int, input().split())
                edges.append((a, b))

            graph = GraphBFS(edges, n)
            discovered = [False] * n
            q = deque()

            for i in range(n):
                if not discovered[i]:
                    discovered[i] = True
                    q.append(i)
                    recursiveBFS(graph, q, discovered)
        elif choice == 3:
            break
        else:
            print("\nInvalid Input\n")

# Time Complexity : O(V + E)
