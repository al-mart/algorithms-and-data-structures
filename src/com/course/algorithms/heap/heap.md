# HEAP

##Priority queue

When a certain element in a collection has the highest weightage or priority
a common use case is to process that first.

Best Structure for this is Binary HEAP 

- Insertion `O(N log N)`
- Removal  `O(N log N)`
- Access - `O(1)`

HEAP is just a tree with a special properties or constraints on the values of its nodes.


###HEAP PROPERTY
- Minimum heap - Every node value should be <= value of its children
 The Node with the smallest value should be the root of the tree.
- Maximum heap - Every node value should be >= value of its children
  The Node with the largest value should be the root of the tree.
 

### SHAPE PROPERTY
IF the H is the H height of the tree - The leaf nodes should only at level h or h-1

HEAP is using an arry where 

Node at index i 
- Left Child is at index `2i + 1`
- Right Child is at index `2i + 2`
- Parent at index `(i - 1 ) /2`


INSERTION - we add an element at the last position and sift it up to find its correct position
REMOVE - we remove the root element and swap the last element with the root after we sift down  to find its correct position
