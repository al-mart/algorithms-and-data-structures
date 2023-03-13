package com.course.datastructures.stackqueue;

import java.lang.reflect.Array;

public class CircularQueue<T> {
    private static final int SPECIAL_EMPTY_VALUE = -1;
    private static final int MAX_SiZE = 40;
    private T[] elements;

    private int headIndex = SPECIAL_EMPTY_VALUE;
    private int tailIndex = SPECIAL_EMPTY_VALUE;

    public CircularQueue(Class<T> clazz){
        elements = (T[]) Array.newInstance(clazz, MAX_SiZE);
    }

    public void enqueue(T data ){
        if(isFull()) throw new RuntimeException();
        tailIndex = (tailIndex + 1 ) % elements.length;
        elements[tailIndex] = data;

        if(headIndex == SPECIAL_EMPTY_VALUE){
            headIndex = tailIndex;
        }
    }

    public T dequeue(){
        if(isEmpty()) throw new RuntimeException();
        T currentData = elements[headIndex];
        if(headIndex == tailIndex){
            headIndex = SPECIAL_EMPTY_VALUE;
        } else {
            headIndex = (headIndex + 1 ) % elements.length;
        }
        return currentData;
    }

    public boolean isEmpty(){
        return headIndex == SPECIAL_EMPTY_VALUE;
    }
    public boolean isFull(){
        int nextIndex = (tailIndex + 1 ) % elements.length;
        return nextIndex == headIndex;
    }

}
