package com.course.algorithms.trees;

public class BinarySearchTree {
    private Node<Integer> root;


    public Node<Integer> insert(Node<Integer> head, Node<Integer> node){
        if (head == null) return node;

        if(node.getData() <= head.getData()){
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }
        return head;
    }

    public Node<Integer> lookup(Node<Integer> head, int data){
        if (head == null) return head;


        if(head.getData() == data){
            return head;
        }
        if (head.getData() > data){
            return lookup(head.getLeftChild(), data);
        } else if (head.getData() < data){
            return lookup(head.getRightChild(), data);
        }
        return null;
    }

    public Integer getMinValue(Node<Integer> head){
        if(head == null) return null;
        if(head.getLeftChild() == null){
            return head.getData();
        }
        return getMinValue(head.getLeftChild());
    }

    public Integer getMaxDepth(Node<Integer> head){
        if(head == null) return 0;

        if(head.getLeftChild() == null && head.getRightChild() == null){
            return 0;
        }

        int leftMax = 1 + getMaxDepth(head.getLeftChild());;
        int rightMax = 1 + getMaxDepth(head.getRightChild());

        return Math.max(leftMax, rightMax);
    }

    public void mirror(Node<Integer> head){
        if(head == null) return;

        mirror(head.getLeftChild());
        mirror(head.getRightChild());

        Node<Integer> temp = head.getRightChild();
        head.setRightChild(head.getLeftChild());
        head.setLeftChild(temp);
    }

    public boolean isBST(Node<Integer> head){
        if(head == null) return false;
        if(head.getData() >= head.getLeftChild().getData() && head.getData() < head.getRightChild().getData()){
            return isBST(head.getLeftChild()) && isBST(head.getRightChild());
        }
        return false;
    }
}
