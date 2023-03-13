package com.course.algorithms.sort;

public class SelectionSort  extends SortBase {

    @Override
    public void sort() {
        for (int i = 0; i < elements.length; i++ ){
            for(int j = i + 1; j < elements.length; j++ ){
                if( elements[i] > elements[j] ){
                    swap(i,j);
                }
            }
        }
    }
}
