package com.course.algorithms.heap;

import java.lang.reflect.Array;

public class HeapBase<T extends Comparable<T>> {
    protected static int MAX_SIZE = 40;
    protected T[] array;

    protected int count = 0;

    public HeapBase(Class<T> clazz) {
        this(clazz, MAX_SIZE);
    }

    public HeapBase(Class<T> clazz, int size) {
        array = (T[]) Array.newInstance(clazz, size);
    }

    public int getLeftChild(int i) {
        int leftChildIndex = 2 * i + 1;
        if (leftChildIndex >= count) {
            return -1;
        }
        return leftChildIndex;
    }

    public int getRightChild(int i) {
        int rightChildIndex = 2 * i + 2;
        if (rightChildIndex >= count) {
            return -1;
        }
        return rightChildIndex;
    }

    public int getParentIndex(int i) {
        if(i < 0 ||  i > count) return  -1;
        return  (i - 1) / 2;
    }

    public void swap(int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int getCount() {
        return count;
    }

    public boolean isFull() {
        return count == array.length;
    }
    public boolean isEmpty() {
        return count == 0;
    }

    public T getElementAtIndex(int i ) {
        return array[i];
    }
}
