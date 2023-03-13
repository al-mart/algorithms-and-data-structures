package com.course.algorithms.sort;

public class BubbleSort extends SortBase {
    @Override
    public void sort() {
        for (int i = 0; i < elements.length; i++) {
            boolean swapped = false;
            for (int j = elements.length - 1; j > i; j--) {
                if (elements[j] < elements[j - 1]){
                    swap(j - 1 , j);
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }
}
