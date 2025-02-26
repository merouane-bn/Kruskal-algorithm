
# Kruskal's Algorithm in Java
# By : MEROUANE BENELABDY
This project is an implementation of Kruskal's algorithm in Java to find the Minimum Spanning Tree (MST) of a given graph.

## Overview

Kruskal's algorithm is a greedy algorithm used to find the MST of a graph. The MST is a subset of the edges that connect all vertices in the graph without any cycles and with the minimum possible total edge weight.

## Files

- `Kruskal.java`: Contains the implementation of Kruskal's algorithm.
- `Edge.java`: Defines the `Edge` class used to represent edges in the graph.

## How to Run

1. **Compile the code:**
    ```sh
    javac Kruskal.java
    ```

2. **Run the program:**
    ```sh
    java Kruskal
    ```

3. **Input the graph details:**
    - Enter the number of vertices.
    - Enter the number of edges.
    - For each edge, enter the source vertex, destination vertex, and the weight.

## Example

Here's an example to test the implementation:

Consider a graph with 4 vertices and 5 edges:

```
(0)---10---(1)
| \       / |
6   5   15  |
|     \     |
(2)---4---(3)
```

### Input

```
Enter the number of vertices:
4
Enter the number of edges:
5
Enter the source of edge 0 :
0
Enter the destination of edge 0 :
1
Enter the source weight of edge 0 :
10
Edge 0 : 0 1 10
Enter the source of edge 1 :
0
Enter the destination of edge 1 :
2
Enter the source weight of edge 1 :
6
Edge 1 : 0 2 6
Enter the source of edge 2 :
0
Enter the destination of edge 2 :
3
Enter the source weight of edge 2 :
5
Edge 2 : 0 3 5
Enter the source of edge 3 :
1
Enter the destination of edge 3 :
3
Enter the source weight of edge 3 :
15
Edge 3 : 1 3 15
Enter the source of edge 4 :
2
Enter the destination of edge 4 :
3
Enter the source weight of edge 4 :
4
Edge 4 : 2 3 4
```

### Output

```
MST:
2 3 4
0 3 5
0 1 10
```

## Detailed Explanation

- **Edge Class (`Edge.java`):** Represents an edge in the graph with source vertex `u`, destination vertex `v`, and weight `weight`. Implements `Comparable` to allow sorting edges by weight.
  
- **Kruskal Class (`Kruskal.java`):** Implements Kruskal's algorithm.
  - **Attributes:**
    - `numVertices`: Number of vertices in the graph.
    - `numEdges`: Number of edges in the graph.
    - `parent`, `rank`: Used for the union-find data structure to detect cycles and manage sets of vertices.
    - `edges`: List of all edges in the graph.
    - `mst`: List of edges in the MST.
  - **Methods:**
    - `makeSet(int x)`: Initializes the parent and rank arrays.
    - `find(int x)`: Finds the representative of the set containing `x` with path compression.
    - `union(int x, int y)`: Unites the sets containing `x` and `y` using union by rank.
    - `kruskal()`: Executes Kruskal's algorithm to find the MST.
    - `printMST()`: Prints the edges in the MST.


## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any changes.
