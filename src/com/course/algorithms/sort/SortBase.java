package com.course.algorithms.sort;

public abstract class SortBase {
    protected int[] elements;

    public abstract void sort();

    public void swap(int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
