# GRAPHS

Graph is used to represent relationships between entities.

A graph is a set of vertices and edges.
`(V, E)`

Undirected (2 way relationships) examples. (A and B are students )
`A - B `

Edges can be directed  (1 way relationships)  examples. (A is the teacher of B )
`A - > B ` A is Source here.

## Therms

VERTEX is an entity.  (people)
EDGE is the relationship. (professional relationship, family, friends)

![](/Users/al.martirosyan/IdeaProjects/algorithms-and-data-structures/src/com/course/algorithms/graph/assets/graph.webp)

6 and 4 are adjacent nodes 3 edges are incident on vertex 5. 5 is said to have a degree of 3.

`6 -> 4 -> 3 -> 2 `

`6 -> 4 -> 5 -> 2 `

` 6 -> 4 -> 5 -> 1 -> 2`

This series of cases are called a path. There are at least one path from 6 to 2 .

`5 -> 2 -> 3 -> 4 -> 5` form a cycle

If you can not get back this graph dont have cycles. so it is called undirected acyclic graph.

The graph is connected if you can get from any vertex to any other .

A connected graph with no cycles is a tree.

If graph is unconnected with no cycles, it is called a forest. a disjoint set of trees.

![](/Users/al.martirosyan/IdeaProjects/algorithms-and-data-structures/src/com/course/algorithms/graph/assets/directed1.jpg)

if D -> A

A -> B -> G -> Would form a cycle.

DAG is a Directed Acyclic graph.

### REPRESENTATION OF GRAPHS IN CODE

- Adjacency matrix
- Adjacency list
- Adjacency set

### Adjacency matrix

Row is source column is destination

|     | A   | B   | C   | D   | E   | F   | G   |
|-----|-----|-----|-----|-----|-----|-----|-----|
| A   |     | 1   |     |     |     |     |     |
| B   |     |     | 1   | 1   | 1   |     |     |
| C   |     |     |     |     | 1   |     |     |
| D   |     |     |     |     | 1   |     |     |
| E   |     |     |     |     |     |     | 1   |
| F   |     |     |     |     |     |     |     |
| G   | 1   |     |     | 1   |     |     |     |

If this graph would be undirected.

|     | A   | B   | C   | D   | E   | F   | G   |
|-----|-----|-----|-----|-----|-----|-----|-----|
| A   |     | 1   |     |     |     |     | 1   |
| B   | 1   |     | 1   | 1   | 1   |     |     |
| C   |     | 1   |     |     | 1   |     |     |
| D   |     | 1   |     |     | 1   |     | 1   |
| E   |     | 1   | 1   | 1   |     |     | 1   |
| F   |     |     |     |     |     |     |     |
| G   | 1   |     |     | 1   | 1   |     |     |

### ADJACENCY LIST
 
Our List
of nodes and each one has a linked list of connected nodes.
A           ->        B
B           ->        C -> D -> E
C           ->        E
D           ->        E
E           ->        G
F           ->        
G           ->        A ->  D

ADJACENCY LIST is not the best representations of graphs.
- The same graph can have multiple representations.
- Deleting a node. we should go through every list and delete it there.

### ADJACENCY LIST

Is just the same, but we store adjacent vertices in a set.


##COMPARISONS 

### Adjacency matrix

- This works well when graph is well-connected.
The <span>V<sup>2</span> space is worth it when the number of connections are large.


### Adjacency list and set

- This works well when the graph is sparse.

E is number of edges V number of vertices

|                          | MATRIX               | LIST        | SET             |
|--------------------------|----------------------|-------------|-----------------|
| SPACE                    | <span>V<sup>2</span> | E + V       | E + V           |
| IS EDGE PRESENT          | 1                    | DEGREE of V | LG(DEGREE of V) |
| ITERATE OVER EDGES ON V  | V                    | DEGREE of V |    DEGREE of V  |

### Graph traversal

- Breadth First 
- Depth First

##Topological sort

It is an ordering of vertices in a directed acyclic graph in which
each node comes before all the nodes to which it has outgoing edges.

Algorithm
- We first find a vertex which has no incoming edge. 
(if there is many, we can take any of them) (multiple topological sorts are possible)

`A -> C A -> B`     Indegree 0
    
`B -> D`            Indegree 2

`C -> E`            Indegree 1 

`D`                 Indegree 2

`E -> B E -> D`     Indegree 1 

`Indegree - number of inward directed graph edges for a given graph vertex.`

So indegree of A node is 0.

If there were no vertices with 0 indegree, then there would have been no topological sort.
So the Graph has a cycle. 

1. We get A and remove it. 

`B -> D`            Indegree 1

`C -> E`            Indegree 0

`D`                 Indegree 2

`E -> B E -> D`     Indegree 1 

2. We get C (it's indegree is  0) and remove it. 

`B -> D`            Indegree 1

`D`                 Indegree 2

`E -> B E -> D`     Indegree 0

3. We get E and remove it 

`B -> D`            Indegree 0

`D`                 Indegree 1

4. We get B 
5. We get E 

Topological sorted list is A, C , E , B, D  

RUNNING TIME IS `O (V + E)`


## SHORTEST PATH ALGORITHMS

Given a graph G with vertices V and edges E
Chose any vertex S - The source 

WHat is the shortest path to the destination vertex D ? 

It is the path with the fewest Hops to get from S to D. We traverse the fewest edges.

`A -> C A -> B`     

`B -> D`            

`C -> E`            

`D`                 

`E -> B E -> D`     

A -> B -> D                 Distance 2

A -> C -> E -> D            Distance 3

A -> C -> E -> B -> D       Distance 4

We need to set up something called distance table we use Breadth first algorithm.

Algorithm we start by initializing every row with -1

| VERTEX | DISTANCE | DESTINATION |
|--------|----------|-------------|
| A      | 0        | A           |
| B      | -1       |             |
| C      | -1       |             |
| D      | -1       |             |
| E      | -1       |             |

We than examine adjacent Vertices that are B and C and add them to the queue.

| VERTEX | DISTANCE | DESTINATION |
|--------|----------|-------------|
| A      | 0        | A           |
| B      | 1        | A           |
| C      | 1        | A           |
| D      | -1       |             |
| E      | -1       |             |

We get the ones adjacent vertices that is C and adjacent is E we enqueue E; 

DISTANCE[E] = DISTANCE[C] + 1;


| VERTEX | DISTANCE | DESTINATION |
|--------|----------|-------------|
| A      | 0        | A           |
| B      | 1        | A           |
| C      | 1        | A           |
| D      | -1       |             |
| E      | 2        | C           |

We remove B from queue and get to D we dont enqueue it as it dont have neighbors.


| VERTEX | DISTANCE | LAST VERTEX |
|--------|----------|-------------|
| A      | 0        | A           |
| B      | 1        | D           |
| C      | 1        | A           |
| D      | 2        | B           |
| E      | 2        | C           |

We Dequeue E its neighbors are B and D . We don't take them as they are already visited.

`In The shortest path algorithms we visit all vertexes only once.`

There would be vertexes that would never be visited.

Use the stack data structure to backtrack from the destination to the source vertex.

PUT D IN THE STACK 
How we get to D from B ( LAST VERTEX ) put B 
same we get A 

Algorithm is done . 
We should check for source on every iteration 

we pop A pop B pop D . this is the shortest path.

###RUNNING TIME
Adjacency List `O(V + E)`

ADJACENCY MATRIX `O(V * V)`


## WEIGHTED GRAPH

A GRAPH having a weight, or number , associated with each node.

Shortest path differences. 

Differences 

1. we initialize every distance with INFINITY.
2. in a weighted graph visi the neighbour 
which is connected by an edge with the lowest weight
use the priority queue to implement this. 
To get to next vertex in the path pop the element with the lowest weight.
3. It's possible to visit a vertex more than once.

Dijkstra's algorithm is a greedy algorithm.

A greedy algorithm builds up solution step by step.
Every step it only optimizes for that particular set it does not look at the overall problem.
It only considers the most obvious benefit of choosing the best possible next step.


Greedy algorithms often fail to find the best solution
They do not operate on all the data, so they may not see the big picture
greedy algorithms are used for optimization problems

Greedy algorithms are especially useful to find approximate solutions to very hard problems.
which are close to impossible to solve (technical term NP hard ) (example traveling salesman problem)

The Algorithm is the same except we put elements in not in stack but in priority queue.

Running Time is `O(E LOG V )` [if binary heaps are used for priority queue]
Running Time is `O(E + V * V )` [if arrays are used for priority queue]


##  SHORTEST PATHS IN NEGATIVE WEIGHTED GRAPHS BELLMAN-FORD ALGORITHM
Not a greedy algorithm 

It processes all the edges. It's a combination of shortest path and Dijkstrast algorithm

To guarantee that we find the shortest path we need V - 1 iterations.

Must deal with negative cycles. 

IF there is a negative cycle we can't find the shortest path.

If the distance of any vertex is updated after the V - 1 iteration. there is a negative cycle

Running Time is `O(E + V )` [if adjacency list is used]
 
Running Time is `O(V^3)` [if adjacency matrix is used] E = V * V.
