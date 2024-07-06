package Interviews.Preparation.DSA.Tree;

import Interviews.Preparation.DSA.Tree.Utility.Node;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("rawtypes")
public class BinarySearchTree {
    Node root;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        // S E A R C H X M P L
        binarySearchTree.put("S", 1);
        binarySearchTree.put("E", 2);
        binarySearchTree.put("A", 3);
        binarySearchTree.put("R", 4);
        binarySearchTree.put("C", 5);
        binarySearchTree.put("H", 6);
        binarySearchTree.put("X", 7);
        binarySearchTree.put("M", 8);
        binarySearchTree.put("P", 9);
        binarySearchTree.put("L", 10);
        TreeTraversal treeTraversal = new TreeTraversal();
        Queue<Comparable> queue = new LinkedList<>();
        treeTraversal.inorderTraversal(binarySearchTree.root, queue);
        treeTraversal.printNode(queue);
        queue = new LinkedList<>();
        treeTraversal.preOrderTraversal(binarySearchTree.root, queue);
        treeTraversal.printNode(queue);
        queue = new LinkedList<>();
        treeTraversal.postOrderTraversal(binarySearchTree.root, queue);
        treeTraversal.printNode(queue);

        System.out.println(binarySearchTree.get(binarySearchTree.root, "J"));
        System.out.println(binarySearchTree.get(binarySearchTree.root, "H"));

    }

    public static void init() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.OrderedListSymbolTableAPI();
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.init();

    }

    private void definition() {
        /*
         * Binary Tree maintaining symmetric order
         * All elements to left of node if smaller
         * All elements to right of node is larger
         * Purpose for this implementation :
         *      compare from root traverse downwards
         *      insert in its place
         *      store its reference in above node (Tricky)
         *      Hence this implementation returning previous nodes
         * Problem :
         *     if the first element is small all element will be placed in right. hence N for search (worst case)
         *     1.39 lg N ->  check more
         *     Hence it may need a good algorithm to insert
         *   */
    }

    void OrderedListSymbolTableAPI() {
        //min() if the left subtree is null
        //max() if the right subtree is null
        //floor() and ceiling()
        //rank - range : maintain a count variable to fetch this
    }

    private void put(String key, int value) {
        root = put(root, key, value);
    }

    private Node put(Node x, String key, int value) {
        if (x == null) return new Node(key, value); // count = 1
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private int get(Node x, String key) {
        if (x == null) return -1;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.left, key);
        } else if (cmp < 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public boolean contains(String key) {
        return get(root, key) != -1;
    }

    private String floor(String key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }

    private Node floor(Node x, String key) {
        //https://www.coursera.org/learn/algorithms-part1/lecture/aJdPT/ordered-operations-in-bsts
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        // if the key is expected return it
        if (cmp == 0) {
            return x;
        }
        // Path towards left and return left child
        if (cmp < 0) {
            return floor(x.left, key);
        }
        // Path towards right if greater return parent itself
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Node getRoot() {
        return root;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        return x.count;
    }

    public int rank(String key) {
        // maintains all elements below it as count (node) both greater and lesser
        // if it is same just provide count\
        // if it is lesser move left path and identify only left path as it is only lesser
        // if it is greater move right path add left to it as it will lesser and also node as it lesser
        return rank(root, key);
    }

    public int rank(Node x, String key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }
}
