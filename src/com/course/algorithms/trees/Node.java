package com.course.algorithms.trees;

public class Node<T extends Comparable<T>> {
    private final T data;

    private Node<T> leftChild;
    private Node<T> rightChild;


    public T getData() {
        return data;
    }

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
