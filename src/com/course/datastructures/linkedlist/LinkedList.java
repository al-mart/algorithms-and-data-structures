package com.course.datastructures.linkedlist;


import com.course.datastructures.Node;

public class LinkedList<T extends Comparable<T>> {
    private Node<T> head = null;

    public LinkedList() {
    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public int countNodes() {
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    public T pop(){
        if(head == null ) return null;
        T data = head.getData();
        head = head.getNext();
        return data;
    }


}
