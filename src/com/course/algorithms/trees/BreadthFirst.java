package com.course.algorithms.trees;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BreadthFirst<T extends Comparable<T>> {

    public static Node<String> root;

    public static void main(String[] args) {
        test();
        visit(root);

    }

    public static void test() {
        BreadthFirst.root = new Node<String>("A");
        root.setLeftChild(new Node<>("B"));
        Node<String> c = new Node<String>("C");
        root.setRightChild(c);
        Node<String> d = new Node<String>("D");
        Node<String> e = new Node<String>("E");
        c.setLeftChild(d);
        c.setRightChild(e);
        Node<String> f = new Node<String>("F");
        Node<String> g = new Node<String>("G");
        Node<String> h = new Node<String>("H");
        d.setLeftChild(f);
        d.setRightChild(g);
        e.setLeftChild(h);

    }

    public static void visit(Node<String> root) {
        if (root == null) return;
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<String> node = queue.poll();
            System.out.println(node.getData());

            if (node.getLeftChild() != null) {
                queue.add(node.getLeftChild());
            }

            if (node.getRightChild() != null) {
                queue.add(node.getRightChild());
            }
        }
    }
}
