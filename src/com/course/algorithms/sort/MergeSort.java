package com.course.algorithms.sort;

public class MergeSort extends SortBase{
    @Override
    public void sort() {
        elements = this.mergeSort(elements);
    }

    public int[] mergeSort(int[] list) {
        if(list.length == 1) return list;
        int midIndex = list.length / 2 + list.length % 2;
        int[] firstHalf = new int[midIndex];
        int[] secondHalf = new int[list.length - midIndex];
        split(list, firstHalf, secondHalf);

        mergeSort(firstHalf);
        mergeSort(secondHalf);
        return merge(list, firstHalf, secondHalf);
    }

    private void split(int[] list, int[] firstHalf, int[] secondHalf){
        int index = 0;
        int secondHalfStartIndex = firstHalf.length;
        for (int element: list){
            if(index < secondHalfStartIndex){
                firstHalf[index] = list[index];
            } else {
                secondHalf[index - secondHalfStartIndex] = list[index];
            }
        }
    }

    private int[] merge(int[] list, int[] firstHalf, int[] secondHalf){
        int mergeIndex = 0;
        int firstHalfIndex = 0;
        int secondHalfIndex = 0;
        
        while(firstHalfIndex < firstHalf.length && secondHalfIndex < secondHalf.length){
            if(firstHalf[firstHalfIndex] < secondHalf[secondHalfIndex]){
                list[mergeIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
            } else {
                list[mergeIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
            }
            mergeIndex++;
        }

        if(firstHalfIndex < firstHalf.length){
            while (mergeIndex < list.length){
                list[mergeIndex] = firstHalf[firstHalfIndex];
                firstHalfIndex++;
                mergeIndex++;
            }
        }

        if(secondHalfIndex < secondHalf.length){
            while (mergeIndex < list.length){
                list[mergeIndex] = secondHalf[secondHalfIndex];
                secondHalfIndex++;
                mergeIndex++;
            }
        }
        return list;
    }

}
