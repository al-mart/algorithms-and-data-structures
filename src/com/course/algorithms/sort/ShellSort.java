package com.course.algorithms.sort;

public class ShellSort extends SortBase {
    @Override
    public void sort() {
        int increment = elements.length / 2;
        while (increment > 0){
            for(int startIndex = 0; startIndex < increment; startIndex++){
                modifiedInsertionSort(startIndex, increment);
            }
            increment /= 2;
        }
    }

    private void modifiedInsertionSort( int startIndex, int increment) {
        for (int i = startIndex; i < elements.length; i += increment)
            for( int j = Math.min(i + increment, elements.length - 1); j - increment >= 0; j-= increment) {
                if (elements[j] < elements[j] - increment){
                    swap(j, j - increment);
                } else{
                    break;
                }
            }
    }
}
