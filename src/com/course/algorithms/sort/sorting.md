# SORTING ALGORITHMS

1. What is complexity? 
2. How much Space it requires? ( Does it requires etra space to store values )
3. Is the sort stable ( Do equal elements maintain their original order ) ?
4. How many comparisons and how many element swaps are needed ( do it works better 
if the list is nearly sorted)
5. Is the sort adaptive ? ( Does it break early when the list is sorted )

### Selection sort 

At each iteration 1 element is selected and compared 
with every other element in the list to find the smallest one.
1. we find the smallest element, get it into the first position.
2. we find second smallest till the entire list is sorted.


1. <span>O(N<sup>2)</span> 
2. `O(1)` No extra space
3. ❌ Not a stable sort 
4. <span>O(N<sup>2)</span> comparisons
5. ❌ Not adaptive 

### Bubble Sort 

For every iteration every element is compared with its neighbor
and swapped if they are not in order.
This results in smaller elements bubbling to the beginning of the list.

1. At the end of the first iteration the smallest element is in the right position,
2. at the end of the second iteration the second smallest is in the place


1. <span>O(N<sup>2)</span>
2. `O(1)` No extra space
3. ✅ Stable sort 
4. <span>O(N<sup>2)</span> comparisons
5. ✅ Adaptive

### Insertion sort

1. Start with a sorted sub-list of size 1
2. Insert the next element into the sorted sub-list at the right position.
Now the sorted sub-list has 2 sorted items 

   
1. <span>O(N<sup>2)</span>
2. `O(1)` No extra space
3. ✅ Stable sort
4. <span>O(N<sup>2)</span> comparisons
5. ✅ Adaptive

### Shell sort 

Is a modified version of insertions sort. 
We pick an increment value and divide in sub-arrays divided by that increment.
After we sort elements in the subarray in regards to themself and decrease increment.
in last iteration it is basically an ordinary insertion sort which is almost sorted.

1. Better than Insertion sort  Between O(N) and <span>O(N<sup>2)</span>
2. `O(1)` No extra space
3. ❌ Not a stable sort
4. -
5. ✅ Adaptive

### Merge sort

It divides in smaller lists and sorts them.
Then it merges and sorts smaller lists.
It's a classic recursion algorithms.


1. <span>O(N log N)</span>
2. `O(N)`extra space
3. ✅ Stable sort
4. -
5. ❌ Not Adaptive

### Quick sort 

List is partitioned in two smaller lists. 
We tak a number and put every element smaller than the number on left, and bigger on right
So the pivot is in its place. 
We continue to sort all smaller lists.


1. <span>O(N log N)</span>
2. `O(log N)`extra space (call stack)
3. ❌ Not Stable sort
4. -
5. ❌ Not Adaptive


## Binary Search

<span>O( log N )</span>


## HeapSort

We heapify the array in place.
We swap first item (Max) with last one and decrement heap size. 

1. <span>O(N log N)</span>
2. `O(1)` no extra space
3. ❌ Not Stable sort
4. -
5. ❌ Not Adaptive
