package com.course.algorithms.sort;

public class BinarySearch {

    public int findRecursive(int item, int[] list) {
        return innerFind(item, list, 0, list.length - 1);
    }

    public Integer innerFind(int item, int[] list, int startIndex, int endIndex) {
        int middle = startIndex + endIndex / 2;
        if (list[middle] == item) {
            return middle;
        } else if (list[middle] > item) {
            return innerFind(item, list, startIndex, middle - 1);
        } else if (list[middle] < item) {
            innerFind(item, list, middle + 1, endIndex);
        }
        return -1;
    }

    public int find(int item, int[] list) {
        int min = 0;
        int max = list.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if( list[mid] == item){
                return mid;
            }
            if(list[mid] > item) {
                max = mid -1 ;
            } else {
                min = mid + 1 ;
            }
        }
        return -1;
    }
}
