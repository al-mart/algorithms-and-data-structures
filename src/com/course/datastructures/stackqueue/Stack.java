package com.course.datastructures.stackqueue;

import com.course.datastructures.Node;

import java.util.EmptyStackException;

public class Stack<T extends Comparable<T>> {
    private static int MAX_SIZE = 40;
    private int size = 0;

    private Node<T> top = null;

    public void push(T data) throws StackOverflowError {
        if (isFull()) throw new StackOverflowError();
        top = new Node<>(data, top);
        size++;
    }

    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T currentData = top.getData();
        top = top.getNext();
        size--;
        return currentData;
    }

    public T peak() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();

        return top.getData();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == MAX_SIZE;
    }
}
