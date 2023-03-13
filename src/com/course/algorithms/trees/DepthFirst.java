package com.course.algorithms.trees;


public class DepthFirst {

    public static Node<String> root;

    public static void main(String[] args) {
        test();
        postOrder(root);
    }

    public static void test() {
        root = new Node<String>("A");
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

    public static void preOrder(Node<String> root) {
        if (root == null) return;

        System.out.println(root.getData());
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static void inOrder(Node<String> root) {
        if (root == null) return;

        inOrder(root.getLeftChild());
        System.out.println(root.getData());
        inOrder(root.getRightChild());
    }

    public static void postOrder(Node<String> root) {
        if (root == null) return;

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.println(root.getData());
    }
}
