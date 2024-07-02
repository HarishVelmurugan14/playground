package Interviews.Preparation.DSA.Tree;

public class BinarySearchTree {
    Node root;

    private BinarySearchTree() {

    }

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.put(2, "Kavi");
        binarySearchTree.put(1, "Harish");
        binarySearchTree.put(3, "Thulasi");
        binarySearchTree.put(4, "Vel");

        String res1 = binarySearchTree.get(binarySearchTree.root, 5);
        binarySearchTree.put(5, "Dinesh");
        String res2 = binarySearchTree.get(binarySearchTree.root, 5);
        System.out.println(res1 + " : " + res2);
    }

    public static BinarySearchTree getInstance() {
        return new BinarySearchTree();
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

    public void init(){
        Node node = new Node(0,"O");
        OrderedListSymbolTableAPI();
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.init();

    }

    void OrderedListSymbolTableAPI() {
        put(1, "Harish");
        get(root, 1);
        //min() if the left subtree is null
        //max() if the right subtree is null
        //floor() and ceiling()
        //rank - range : maintain a count variable to fetch this
    }

    private void put(int key, String value) {
        root = put(root, key, value);
    }

    private Node put(Node x, int key, String value) {
        if (x == null) return new Node(key, value); // count = 1
        if (key < x.key) {
            x.left = put(x.left, key, value);
        } else if (key > x.key) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
//        x.count = 1 + size(x.left) + size(x.right);
        return x;
    }

    private String get(Node x, int key) {
        if (x == null) return null;
        if (key < x.key) {
            return get(x.left, key);
        } else if (key > x.key) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    public Node getRoot(){
        return root;
    }

    public class Node {
        private int key;
        private String value;
        private Node left, right;
//        private int count;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
//            this.count = count;
        }
    }
}
