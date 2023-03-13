package com.course.algorithms.sort;

public class QuickSort extends SortBase {
    @Override
    public void sort() {
        quickSort(elements, 0, elements.length - 1);
    }

    public void quickSort(int[] list, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = partition(list, low, high);
        quickSort(list, low, pivotIndex);
        quickSort(list, pivotIndex + 1, high);
    }

    private int partition(int[] list, int low, int high) {
        int pivot = list[low];
        int l = low;
        int h = high;
        while (l < h) {
            while (list[l] <= pivot && l < h) {
                l++;
            }
            while (list[h] > pivot) {
                h--;
            }
            if (l < h) {
                swap(l, h);
            }
        }
        swap(low, h);
        return h;
    }
}
