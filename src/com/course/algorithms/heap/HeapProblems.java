package com.course.algorithms.heap;

public class HeapProblems {


    // Get Max element in Min Heap We must scan all elements after the parent of last element
    public int maxNodeInMinHeap(Heap<Integer> minHeap) {
        int lastIndex = minHeap.getCount() - 1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstLeafIndex = lastParentIndex +1;
        int maxElement = minHeap.getElementAtIndex(firstLeafIndex);
        for(int i = firstLeafIndex; i <= lastIndex; i++){
            if(maxElement < minHeap.getElementAtIndex(i)){
                maxElement = minHeap.getElementAtIndex(i);
            }
        }
        return maxElement;
    }
}
