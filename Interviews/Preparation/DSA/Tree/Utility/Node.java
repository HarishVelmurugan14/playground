package Interviews.Preparation.DSA.Tree.Utility;

public class Node {
    public String key;
    public int value;
    public Node left, right;
    public int count;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.count = 1;
    }
}
