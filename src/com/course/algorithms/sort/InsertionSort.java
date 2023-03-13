package com.course.algorithms.sort;

public class InsertionSort extends SortBase {
    @Override
    public void sort() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (elements[j] < elements[j - 1]) {
                    swap(i, j);
                } else {
                    break;
                }
            }
        }
    }
}
