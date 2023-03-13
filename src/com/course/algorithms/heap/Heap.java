package com.course.algorithms.heap;


/**
 * Minimum Heap
 */
public class Heap<T extends Comparable<T>> extends HeapBase<T> {


    public Heap(Class<T> clazz) {
        super(clazz);
    }

    public Heap(Class<T> clazz, int size) {
        super(clazz, size);
    }

    public void insert(T value){
        if(count >= array.length) return;

        array[count] = value;
        siftUp(count);
        count++;
    }

    public T remove() {
        T data = null;
        if(count != 0){
            data = array[0];
        }

        array[0] = array[count - 1];
        count--;
        siftDown(0);
        return data;
    }

    private void siftUp(int index){
        int parentIndex = getParentIndex(index);
        if(parentIndex != -1 && getElementAtIndex(index).compareTo(getElementAtIndex(parentIndex)) < 0){
            swap(index, parentIndex);
            siftUp(parentIndex);
        }
    }


    private void siftDown(int index){
        int leftIndex = getLeftChild(index);
        int rightIndex = getRightChild(index);

        int minIndex = -1;
        if(leftIndex != -1 && rightIndex != -1){
            minIndex = getElementAtIndex(leftIndex).compareTo(getElementAtIndex(rightIndex)) < 0 ? leftIndex : rightIndex;
        } else if(leftIndex != -1) {
            minIndex = leftIndex;
        } else if(rightIndex != -1){
            minIndex = rightIndex;
        }

        if(minIndex == -1) return;

        if(getElementAtIndex(index).compareTo(getElementAtIndex(minIndex)) < 0){
            swap(index, minIndex);
            siftDown(minIndex);
        }
    }
}
