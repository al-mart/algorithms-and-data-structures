package com.course.datastructures;

public class Node<T extends Comparable<T>> {
    private final T data;
    private Node<T> next;

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node(T data) {
        this.data = data;
        this.setNext(null);
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.setNext(next);
    }

    @Override
    public String toString(){
        return String.valueOf(data);
    }
}
