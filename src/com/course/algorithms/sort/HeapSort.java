package com.course.algorithms.sort;

import com.course.algorithms.heap.HeapBase;

/**
 * Heap sort uses Maximum heap
 */
public class HeapSort extends HeapBase<Integer> {

    public HeapSort(Class<Integer> clazz) {
        super(clazz);
    }

    public HeapSort(Class<Integer> clazz, int size) {
        super(clazz, size);
    }

    public void heapSort() {
        int endIndex = array.length - 1;
        heapify(endIndex);

        while(endIndex > 0){
            swap(0, endIndex);
            endIndex--;
            siftDown(0, endIndex);
        }
    }

    private void siftDown(int index, int endIndex) {
        int leftIndex = getLeftChild(index, endIndex);
        int rightIndex = getRightChild(index, endIndex);

        if (leftIndex != -1 && array[leftIndex] > array[index]) {
            swap(leftIndex, index);
            siftDown(leftIndex, endIndex);
        }
        if (rightIndex != -1 && array[rightIndex] > array[index]) {
            swap(rightIndex, index);
            siftDown(rightIndex, endIndex);
        }
    }

    public int getLeftChild(int i, int endIndex) {
        int leftChildIndex = 2 * i + 1;
        if (leftChildIndex >= endIndex) {
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChild(int i, int endIndex) {
        int rightChildIndex = 2 * i + 2;
        if (rightChildIndex >= endIndex) {
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int i, int endIndex) {
        if (i < 0 || i > endIndex) return -1;
        return (i - 1) / 2;
    }

    public void heapify(int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            siftDown(index, endIndex);
            index--;
        }
    }
}
