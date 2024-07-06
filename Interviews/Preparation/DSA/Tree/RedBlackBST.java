package Interviews.Preparation.DSA.Tree;

public class RedBlackBST {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    static Node root;

    public static void init() {
        //S, E, A, R, C, H, X, M, P, L
        put(1, "S");
        put(4, "R");
        put(3, "A");
        put(5, "C");
        put(7, "X");
        put(2, "E");
        put(6, "H");
        put(10, "L");
        put(9, "P");
        put(8, "M");
        String x = get(root, 8);
        System.out.println(x);
    }

    private static void put(int key, String value) {
        root = put(root, key, value);
    }

    private static Node put(Node x, int key, String value) {
        if (x == null) return new Node(key, value, RED); // count = 1
        if (key < x.key) {
            x.left = put(x.left, key, value);
        } else if (key > x.key) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }
//        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private static String get(Node x, int key) {
        if (x == null) return null;
        if (key < x.key) {
            return get(x.left, key);
        } else if (key > x.key) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }


    private static boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private static Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private static Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private static void flipColors(Node h) {
        h.left.color = BLACK;
        h.right.color = BLACK;
        h.color = RED;
    }


    private static class Node {
        private int key;
        private String value;
        private Node left, right;
        private boolean color;
//        private int count;

        public Node(int key, String value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
//            this.count = count;
        }
    }

}
