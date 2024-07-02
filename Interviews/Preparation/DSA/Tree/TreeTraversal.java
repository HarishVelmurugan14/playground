package Interviews.Preparation.DSA.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.init();
    }

    public void init() {
        Queue<Integer> q = new LinkedList<>();
        Node root = new Node(50, 1);
        root.left = new Node(30, 2);
        root.left.left = new Node(20, 3);
        root.left.right = new Node(40, 4);
        root.right = new Node(70, 5);
        root.right.left = new Node(60, 6);
        root.right.right = new Node(80, 7);
        inorderTraversal(root, q);

        System.out.println("In Order");
        for (int element : q) {
            System.out.print(element + " ");
        }

        System.out.println("\nPre Order");
//        50, 30, 20, 40, 70, 60, 80.
        q = new LinkedList<>();
        preOrderTraversal(root, q);

        for (int element : q) {
            System.out.print(element + " ");
        }
        System.out.println("\nPost Order");
//        20, 40, 30, 60, 80, 70, 50.
        q = new LinkedList<>();
        postOrderTraversal(root, q);

        for (int element : q) {
            System.out.print(element + " ");
        }

    }

    private void inorderTraversal(Node x, Queue<Integer> q) {
        /*
         * queue left subtree
         * queue node
         * queue right subtree
         *
         * provide ordered array as such
         */
        if (x == null) return;
        inorderTraversal(x.left, q);
        q.offer(x.key);
        inorderTraversal(x.right, q);

    }

    private void preOrderTraversal(Node x, Queue<Integer> q) {
        /*
         * queue node
         * queue left till its last
         * backtrack
         * queue right
         */
        if (x != null) {
            q.offer(x.key);
            preOrderTraversal(x.left, q);
            preOrderTraversal(x.right, q);
        }
    }

    private void postOrderTraversal(Node x, Queue<Integer> q) {
        /*
         * queue left child
         * queue right child
         * backtrack
         * queue node
         * replica of pre with alter
         */
        if (x != null) {
            postOrderTraversal(x.left, q);
            postOrderTraversal(x.right, q);
            q.offer(x.key);
        }
    }

    public class Node {
        private int key;
        private int value;
        private Node left, right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
