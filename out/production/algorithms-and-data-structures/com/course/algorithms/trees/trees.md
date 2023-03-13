#TREES
A tree is a data structure which is made up of nodes, each node can point to a number of nodes.

- ROOT - The starting node that don't have a parent.
- EDGE - A Link from a parent node to a child node.
- LEAF - A node that don't have a child.
- SIBLINGS - nodes that have the same distance from the parent. same level nodes
- ANCESTOR - node that have a reaching path to a child.
- DESCENDANT - node that have a reaching path to a parent.

ROOT is the ancestor of every node.
Every node is a descendant of ROOT.

## Binary trees

Each node can have 0, 1 and 2 children.

###VISITING ALGORITHMS (Traversing, processing the tree)

- BREADTH First - Visit all levels than move to the next level 

- DEPTH First - Visit to the last leaf than move up.
  - PRE-ORDER - The PARENT is processed Before its left and right leafs
  - IN-ORDER - The Left leaf the parent and the right leaf
  - POST-ORDER - Left Right Parent. 
